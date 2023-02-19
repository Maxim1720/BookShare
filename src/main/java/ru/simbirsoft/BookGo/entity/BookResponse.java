package ru.simbirsoft.BookGo.entity;

import javax.persistence.*;
import java.util.Date;

@SequenceGenerator(name = "bookResponseSeqPK", sequenceName = "bookResponseSeqPK")
@Entity
@Table(name = "BookResponse")
public class BookResponse {

    @Id
    @GeneratedValue(generator = "bookResponseSeqPK")
    @Column(name = "idBookResponse", nullable = false)
    private int idBookResponse;

    @ManyToOne(targetEntity = BookLiterary.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idBookLiterary", referencedColumnName = "idBookLiterary")
    private BookLiterary bookLiterary;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    private User user;

    @Column(name = "createAt", nullable = false)
    private Date createAt;

    @Column(name = "response", nullable = false, length = 500)
    private String response;

    @Column(name = "note", length = 50)
    private String note;

    public int getIdBookResponse() {
        return idBookResponse;
    }

    public void setIdBookResponse(int idBookResponse) {
        this.idBookResponse = idBookResponse;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BookResponse() {
    }
}
