package ru.simbirsoft.BookGo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "statusSeqPK", sequenceName = "statusSeqPK")
@Entity
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(generator = "statusSeqPK")
    @Column(name = "idStatus", nullable = false)
    private int idStatus;

    @Column(name = "name", nullable = false, unique = true, length = 10)
    private String name;

    @OneToMany(targetEntity = UserMsg.class, mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserMsg> userMsgs = new HashSet<>();


    @OneToMany(targetEntity = WishList.class, mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<WishList> wishLists = new HashSet<>();


    @OneToMany(targetEntity = OfferList.class, mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OfferList> offerLists = new HashSet<>();

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserMsg> getUserMsgs() {
        return userMsgs;
    }

    public void setUserMsgs(Set<UserMsg> userMsgs) {
        this.userMsgs = userMsgs;
    }

    public Set<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(Set<WishList> wishLists) {
        this.wishLists = wishLists;
    }

    public Set<OfferList> getOfferLists() {
        return offerLists;
    }

    public void setOfferLists(Set<OfferList> offerLists) {
        this.offerLists = offerLists;
    }

    public Status() {
    }
}
