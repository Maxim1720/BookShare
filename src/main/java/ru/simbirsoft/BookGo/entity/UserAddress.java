package ru.simbirsoft.BookGo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "userAddressSeqPK", sequenceName = "userAddressSeqPK")
@Entity
@Table(name = "UserAddress")
public class UserAddress {

    @Id
    @GeneratedValue(generator = "userAddressSeqPK")
    @Column(name = "idUserAddress", nullable = false)
    private int idUserAddress;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    private User user;

    @Column(name = "addrIndex", nullable = false, length = 6)
    private String addrIndex;

    @Column(name = "addrCity", nullable = false, length = 15)
    private String addrCity;

    @Column(name = "addrStreet", nullable = false, length = 25)
    private String addrStreet;

    @Column(name = "addrHouse", nullable = false, length = 5)
    private String addrHouse;

    @Column(name = "addrStructure", length = 10)
    private String addrStructure;

    @Column(name = "addrApart", length = 3)
    private String addrApart;

    @Column(name = "isDefault", nullable = false, columnDefinition = "boolean default false")
    private boolean isDefault;


    @OneToMany(targetEntity = WishList.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<WishList> wishLists = new HashSet<>();

    public int getIdUserAddress() {
        return idUserAddress;
    }

    public void setIdUserAddress(int idUserAddress) {
        this.idUserAddress = idUserAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddrIndex() {
        return addrIndex;
    }

    public void setAddrIndex(String addrIndex) {
        this.addrIndex = addrIndex;
    }

    public String getAddrCity() {
        return addrCity;
    }

    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }

    public String getAddrStreet() {
        return addrStreet;
    }

    public void setAddrStreet(String addrStreet) {
        this.addrStreet = addrStreet;
    }

    public String getAddrHouse() {
        return addrHouse;
    }

    public void setAddrHouse(String addrHouse) {
        this.addrHouse = addrHouse;
    }

    public String getAddrStructure() {
        return addrStructure;
    }

    public void setAddrStructure(String addrStructure) {
        this.addrStructure = addrStructure;
    }

    public String getAddrApart() {
        return addrApart;
    }

    public void setAddrApart(String addrApart) {
        this.addrApart = addrApart;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public Set<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(Set<WishList> wishLists) {
        this.wishLists = wishLists;
    }

    public UserAddress() {
    }
}
