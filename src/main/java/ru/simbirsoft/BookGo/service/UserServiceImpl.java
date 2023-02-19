package ru.simbirsoft.BookGo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.simbirsoft.BookGo.dto.UserDTO;
import ru.simbirsoft.BookGo.entity.User;
import ru.simbirsoft.BookGo.exception.UserException;
import ru.simbirsoft.BookGo.exception.UserExceptionEnum;
import ru.simbirsoft.BookGo.repository.TokenRepository;
import ru.simbirsoft.BookGo.repository.UserRepository;
import ru.simbirsoft.BookGo.security.VerificationToken;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    private final MailSender mailSender;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final TokenRepository tokenRepository;

    @Value("${spring.host}")
    private String host;


    @Autowired
    public UserServiceImpl(MailSender mailSender,
                           UserRepository userRepository,
                           PasswordEncoder encoder,
                           TokenRepository tokenRepository) {
        this.mailSender = mailSender;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.tokenRepository = tokenRepository;
    }

    public User createUser(UserDTO userDTO) throws UserException {
        if(validateUser(userDTO)) {
            throw new UserException(UserExceptionEnum.USER_EXIST, userDTO.getEmail());
        }
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setSecondName(userDTO.getSecondName());
        user.setAvatar(userDTO.getAvatar());

        return userRepository.save(user);
    }

    public void activateUser(User user) {
        user.setEnabled(true);
        userRepository.save(user);
    }
    @Override
    public void createVerificationToken(User user, String token) {
        VerificationToken createdToken = new VerificationToken(token, user);
        tokenRepository.save(createdToken);
    }

    @Override
    public VerificationToken getVerificationToken(String verificationToken) {
        return tokenRepository.findByToken(verificationToken);
    }

    private boolean validateUser(UserDTO userDTO) {
        return userRepository.findUserByEmail(userDTO.getEmail()).isPresent();
    }
}
