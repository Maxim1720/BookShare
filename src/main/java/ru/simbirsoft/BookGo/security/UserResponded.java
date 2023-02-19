package ru.simbirsoft.BookGo.security;

import ru.simbirsoft.BookGo.entity.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Класс пользователя, который скрывает приватные данные.
 * Используется в качестве возвращаемого значения из контроллера.
 */
public class UserResponded implements Serializable {
    private long id;
    private String fisrtName;
    private String lastName;
    private String secondName;
    private String userName;
    private int rating;
    private Date createdAt;
    private byte[] avatar;
    private boolean isStaff;
    private boolean isSuperAdmin;

    public long getId() {
        return id;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public boolean isStaff() {
        return isStaff;
    }

    public void setStaff(boolean staff) {
        isStaff = staff;
    }

    public boolean isSuperAdmin() {
        return isSuperAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        isSuperAdmin = superAdmin;
    }

    public UserResponded map(User user) {
        UserResponded userResponded = new UserResponded();
        userResponded.id = user.getIdUser();
        userResponded.fisrtName = user.getFisrtName();
        userResponded.lastName = user.getLastName();
        userResponded.secondName = user.getSecondName();
        userResponded.userName = user.getUserName();
        userResponded.rating = user.getRating();
        userResponded.createdAt = user.getCreatedAt();
        userResponded.avatar = user.getAvatar();
        userResponded.isStaff = user.isStaff();
        userResponded.isSuperAdmin = user.isSuperAdmin();

        return userResponded;
    }
}
