package ru.simbirsoft.BookGo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "offerListSeqPK", sequenceName = "offerListSeqPK")
@Entity
@Table(name = "OfferList")
public class OfferList {

    @Id
    @GeneratedValue(generator = "offerListSeqPK")
    @Column(name = "idOfferList", nullable = false)
    private int idOfferList;

    @ManyToOne(targetEntity = BookLiterary.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "IdBookLiterary", referencedColumnName = "IdBookLiterary")
    private BookLiterary bookLiterary;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    private User user;

    @Column(name = "isbn", nullable = false, length = 13)
    private String isbn;

    @Column(name = "yearPublishing", nullable = false)
    private Date yearPublishing;


    @Column(name = "createAt", nullable = false)
    private Date createAt;


    @Column(name = "updateAt", nullable = false)
    private Date updateAt;


    @OneToMany(targetEntity = UserList.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserList> userLists = new HashSet<>();

    @OneToOne(targetEntity = ExchangeList.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ExchangeList exchangeList = new ExchangeList();

    @OneToOne(targetEntity = UserExchangeList.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserExchangeList userExchangeList = new UserExchangeList();

    @ManyToOne(targetEntity = Status.class,  cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idStatus",columnDefinition = "integer default 1", referencedColumnName = "idStatus")
    private Status status;

    public int getIdOfferList() {
        return idOfferList;
    }

    public void setIdOfferList(int idOfferList) {
        this.idOfferList = idOfferList;
    }

    public BookLiterary getBookLiterary() {
        return bookLiterary;
    }

    public void setBookLiterary(BookLiterary bookLiterary) {
        this.bookLiterary = bookLiterary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getYearPublishing() {
        return yearPublishing;
    }

    public void setYearPublishing(Date yearPublishing) {
        this.yearPublishing = yearPublishing;
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

    public UserExchangeList getUserExchangeList() {
        return userExchangeList;
    }

    public void setUserExchangeList(UserExchangeList userExchangeList) {
        this.userExchangeList = userExchangeList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public OfferList() {
    }
}
