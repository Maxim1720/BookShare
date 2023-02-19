package ru.simbirsoft.BookGo.dto;

import ru.simbirsoft.BookGo.entity.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDTO {
    //TODO Требуется правильно описать DTO и сервис по его маппингу

    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    private String secondName;

    private byte[] avatar;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public UserDTO map(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.userName = user.getUserName();
        userDTO.email = user.getEmail();
        userDTO.password = user.getPassword();
        userDTO.firstName = user.getFisrtName();
        userDTO.lastName = user.getLastName();
        userDTO.secondName = user.getSecondName();
        userDTO.avatar = userDTO.getAvatar();

        return userDTO;
    }

}
