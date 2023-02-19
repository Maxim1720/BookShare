package ru.simbirsoft.BookGo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "authorSeqPK", sequenceName = "authorSeqPK")
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(generator = "authorSeqPK")
    @Column(name = "id_author", nullable = false)
    private int idAuthor;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstname;

    @Column(name = "last_Name", nullable = false, length = 20)
    private String lastName;

    @OneToMany(targetEntity = BookLiterary.class,
            mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BookLiterary> bookLiteraries = new HashSet<>();

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<BookLiterary> getBookLiteraries() {
        return bookLiteraries;
    }

    public void setBookLiteraries(Set<BookLiterary> bookLiteraries) {
        this.bookLiteraries = bookLiteraries;
    }

    public Author() {
    }
}
