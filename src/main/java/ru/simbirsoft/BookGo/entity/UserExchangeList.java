package ru.simbirsoft.BookGo.entity;

import javax.persistence.*;

@SequenceGenerator(name = "userExchangeListSeqPK", sequenceName = "userExchangeListSeqPK")
@Entity
@Table(name = "UserExchangeList")
public class UserExchangeList {

    @Id
    @GeneratedValue(generator = "userExchangeListSeqPK")
    @Column(name = "idUserExchangeList", nullable = false)
    private int idUserExchangeList;


    @ManyToOne(targetEntity = ExchangeList.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idExchangeList", referencedColumnName = "idExchangeList")
    private ExchangeList exchangeList;


    @OneToOne(targetEntity = OfferList.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idOfferList", referencedColumnName = "idOfferList")
    private OfferList offerList;


    @Column(name = "trackNumber", nullable = false, length = 14)
    private String trackNumber;


    @Column(name = "receiving", nullable = false)
    private boolean receiving;

    public int getIdUserExchangeList() {
        return idUserExchangeList;
    }

    public void setIdUserExchangeList(int idUserExchangeList) {
        this.idUserExchangeList = idUserExchangeList;
    }

    public ExchangeList getExchangeList() {
        return exchangeList;
    }

    public void setExchangeList(ExchangeList exchangeList) {
        this.exchangeList = exchangeList;
    }

    public OfferList getOfferList() {
        return offerList;
    }

    public void setOfferList(OfferList offerList) {
        this.offerList = offerList;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public boolean isReceiving() {
        return receiving;
    }

    public void setReceiving(boolean receiving) {
        this.receiving = receiving;
    }

    public UserExchangeList() {
    }
}
