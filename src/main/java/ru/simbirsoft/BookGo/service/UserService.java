package ru.simbirsoft.BookGo.service;

import ru.simbirsoft.BookGo.dto.UserDTO;
import ru.simbirsoft.BookGo.entity.User;
import ru.simbirsoft.BookGo.exception.UserException;
import ru.simbirsoft.BookGo.security.VerificationToken;

public interface UserService {
    /**
     * Создать пользователя и занести его в БД.
     * Такой пользователь ещё не активирован.
     *
     * @param userDTO           ДТО пользователя, принятого с контроллера
     * @return                  сущность User, если получилось занести в БД, иначе - null
     * @throws UserException    исключение при создании пользователя (пользователь уже существует...)
     */
    User createUser(UserDTO userDTO) throws UserException;

    /**
     * Создание токена для верификации пользователя через email.
     *
     * @param user              пользователь из БД
     * @param token             токен
     */
    void createVerificationToken(User user, String token);

    /**
     * Получение токена из БД.
     *
     * @param VerificationToken имя токена
     * @return                  сущность токена из БД
     */
    VerificationToken getVerificationToken(String VerificationToken);

    /**
     * Активация пользователя, изменение enabled на true.
     *
     * @param user              сущность пользователя из БД
     */
    void activateUser(User user);
}
