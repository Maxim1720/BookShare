package ru.simbirsoft.BookGo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "bookLiterarySeqPK", sequenceName = "bookLiterarySeqPK")
@Entity
@Table(name = "BookLiterary")
public class BookLiterary {

    @Id
    @GeneratedValue(generator = "bookLiterarySeqPK")
    @Column(name = "idBookLiterary", nullable = false)
    private int idBookLiterary;

    @ManyToOne(targetEntity = Author.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_author", referencedColumnName = "id_author")
    private Author author;

    @Column(name = "bookName", nullable = false, length = 50)
    private String bookName;

    @Column(name = "note", length = 50)
    private String note;

    @OneToMany(targetEntity = BookResponse.class, mappedBy = "bookLiterary", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BookResponse> bookResponses = new HashSet<>();

    @OneToMany(targetEntity = OfferList.class, mappedBy = "bookLiterary", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OfferList> offerLists = new HashSet<>();

    public int getIdBookLiterary() {
        return idBookLiterary;
    }

    public void setIdBookLiterary(int idBookLiterary) {
        this.idBookLiterary = idBookLiterary;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<BookResponse> getBookResponses() {
        return bookResponses;
    }

    public void setBookResponses(Set<BookResponse> bookResponses) {
        this.bookResponses = bookResponses;
    }

    public Set<OfferList> getOfferLists() {
        return offerLists;
    }

    public void setOfferLists(Set<OfferList> offerLists) {
        this.offerLists = offerLists;
    }

    public BookLiterary() {
    }
}
