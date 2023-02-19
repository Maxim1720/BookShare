package ru.simbirsoft.BookGo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.simbirsoft.BookGo.dto.UserDTO;
import ru.simbirsoft.BookGo.entity.User;
import ru.simbirsoft.BookGo.exception.UserException;
import ru.simbirsoft.BookGo.event.OnRegistrationCompleteEvent;
import ru.simbirsoft.BookGo.exception.UserExceptionEnum;
import ru.simbirsoft.BookGo.security.VerificationToken;
import ru.simbirsoft.BookGo.service.NicknameGenerator;
import ru.simbirsoft.BookGo.service.UserService;
import ru.simbirsoft.BookGo.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.Locale;

@RestController
public class UserController {

    private final NicknameGenerator nicknameGenerator;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;


    @Autowired
    public UserController(UserService userService,
                          NicknameGenerator nicknameGenerator,
                          ApplicationEventPublisher eventPublisher) {
        this.userService = userService;
        this.nicknameGenerator = nicknameGenerator;
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@Valid @RequestBody UserDTO userDTO,
                                               HttpServletRequest request) {
        try {
            User user = userService.createUser(userDTO);
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user,
                    request.getLocale(), request.getContextPath()));
            return ResponseEntity.ok("Success!");
        } catch (UserException ex) {
            return ResponseEntity.badRequest().body(ex.getExceptionEnum().getMessage() + " " + ex.getMessage());
        }
    }

    @GetMapping("/registration/activate")
    public ResponseEntity<String> activate(@RequestParam("token") String token) {
        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            return ResponseEntity.badRequest().body(UserExceptionEnum.TOKEN_INVALID.getMessage());
        }

        User user = verificationToken.getUser();
        if(user == null) {
            return ResponseEntity.badRequest().body(UserExceptionEnum.USER_NOT_FOUND.getMessage());
        }

        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            return ResponseEntity.badRequest().body(UserExceptionEnum.TOKEN_EXPIRED.getMessage());
        }

        userService.activateUser(user);
        return ResponseEntity.ok().body("Success!");
    }

    @GetMapping(value = "/registration/generateNickname", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getNickname() {
        return ResponseEntity.ok(nicknameGenerator.getNickname());
    }

}
