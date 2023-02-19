package ru.simbirsoft.BookGo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "wishListSeqPK", sequenceName = "wishListSeqPK")
@Entity
@Table(name = "WishList")
public class WishList {

    @Id
    @GeneratedValue(generator = "wishListSeqPK")
    @Column(name = "idWishList", nullable = false)
    private int idWishList;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    private User user;

    @Column(name = "createAt", nullable = false)
    private Date createAt;


    @Column(name = "updateAt", nullable = false)
    private Date updateAt;

    @ManyToOne(targetEntity = UserAddress.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUserAddress", referencedColumnName = "idUserAddress")
    private UserAddress userAddress;

    @OneToMany(targetEntity = UserList.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserList> userLists = new HashSet<>();

    @OneToOne(targetEntity = ExchangeList.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ExchangeList exchangeList = new ExchangeList();

    @ManyToOne(targetEntity = Status.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idStatus", referencedColumnName = "idStatus")
    private Status status;

    public int getIdWishList() {
        return idWishList;
    }

    public void setIdWishList(int idWishList) {
        this.idWishList = idWishList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public Set<UserList> getUserLists() {
        return userLists;
    }

    public void setUserLists(Set<UserList> userLists) {
        this.userLists = userLists;
    }

    public ExchangeList getExchangeList() {
        return exchangeList;
    }

    public void setExchangeList(ExchangeList exchangeList) {
        this.exchangeList = exchangeList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public WishList() {
    }
}
