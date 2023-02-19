package ru.simbirsoft.BookGo.entity;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "userAccountSeqPK", sequenceName = "userAccountSeqPK")
@Entity
@Table(name = "UserAccount")
public class User {

    @Id
    @GeneratedValue(generator = "userAccountSeqPK")
//    @Column(name = "idUser", nullable = false)
    @Column(name = "idUser")
    private int idUser;

    @Column(name = "firstName", nullable = false, length = 25)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "secondName", length = 25)
    private String secondName;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "userName", nullable = false, length = 20)
    private String userName;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "rating", nullable = false, columnDefinition = "integer default 0")
    private int rating;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "enabled", nullable = false, columnDefinition = "boolean default true")
    private boolean enabled;

    @Lob
    @Column(name = "avatar", columnDefinition="oid")
    private byte[] avatar;

    @Column(name = "isStaff", nullable = false, columnDefinition = "boolean default false")
    private boolean isStaff;

    @Column(name = "isSuperAdmin", nullable = false, columnDefinition = "boolean default false")
    private boolean isSuperAdmin;

    @OneToMany(targetEntity = BookResponse.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BookResponse> bookResponses = new HashSet<>();

    @OneToMany(targetEntity = UserAddress.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserAddress> userAddresses = new HashSet<>();

    @OneToMany(targetEntity = UserMsg.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserMsg> userMsgs = new HashSet<>();


    @OneToMany(targetEntity = WishList.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<WishList> wishLists = new HashSet<>();


    @OneToMany(targetEntity = OfferList.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OfferList> offerLists = new HashSet<>();


    public User() {
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFisrtName() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword(){
        return password;
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

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public boolean isEnabled() {
        return enabled;
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

    public Set<BookResponse> getBookResponses() {
        return bookResponses;
    }

    public void setBookResponses(Set<BookResponse> bookResponses) {
        this.bookResponses = bookResponses;
    }

    public Set<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(Set<UserAddress> userAddresses) {
        this.userAddresses = userAddresses;
    }

    public Set<UserMsg> getUserMsgs() {
        return userMsgs;
    }

    public void setUserMsgs(Set<UserMsg> userMsgs) {
        this.userMsgs = userMsgs;
    }
}
