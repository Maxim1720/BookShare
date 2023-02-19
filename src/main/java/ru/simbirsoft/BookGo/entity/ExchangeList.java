package ru.simbirsoft.BookGo.entity;

import javax.persistence.*;
import java.util.Date;

@SequenceGenerator(name = "exchangeListSeqPK", sequenceName = "exchangeListSeqPK")
@Entity
@Table(name = "ExchangeList")
public class ExchangeList {

    @Id
    @GeneratedValue(generator = "exchangeListSeqPK")
    @Column(name = "idExchangeList", nullable = false)
    private int idExchangeList;


    @OneToOne(targetEntity = OfferList.class, mappedBy = "exchangeList", cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idOfferList1", referencedColumnName = "idOfferList1")
    private OfferList offerList1;


    @OneToOne(targetEntity = WishList.class, mappedBy = "exchangeList", cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idWishList1", referencedColumnName = "idWishList1")
    private WishList wishList1;


    @OneToOne(targetEntity = OfferList.class, mappedBy = "exchangeList", cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idOfferList2", referencedColumnName = "idOfferList2")
    private OfferList offerList2;


    @OneToOne(targetEntity = WishList.class, mappedBy = "exchangeList", cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idWishList2", referencedColumnName = "idWishList2")
    private WishList wishList2;


    @Column(name = "createAt", nullable = false)
    private Date createAt;


    @Column(name = "IsBoth", nullable = false)
    private boolean IsBoth;

    public int getIdExchangeList() {
        return idExchangeList;
    }

    public void setIdExchangeList(int idExchangeList) {
        this.idExchangeList = idExchangeList;
    }

    public OfferList getOfferList1() {
        return offerList1;
    }

    public void setOfferList1(OfferList offerList1) {
        this.offerList1 = offerList1;
    }

    public WishList getWishList1() {
        return wishList1;
    }

    public void setWishList1(WishList wishList1) {
        this.wishList1 = wishList1;
    }

    public OfferList getOfferList2() {
        return offerList2;
    }

    public void setOfferList2(OfferList offerList2) {
        this.offerList2 = offerList2;
    }

    public WishList getWishList2() {
        return wishList2;
    }

    public void setWishList2(WishList wishList2) {
        this.wishList2 = wishList2;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public boolean isBoth() {
        return IsBoth;
    }

    public void setBoth(boolean both) {
        IsBoth = both;
    }

    public ExchangeList() {
    }
}
