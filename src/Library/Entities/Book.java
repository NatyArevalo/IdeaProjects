package Library.Entities;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long ISBN;
    private String title;
    private Integer anio;
    private Integer copies;
    private Integer borrowedCopies;
    private Integer remainingCopies;
    private Boolean active = true;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;

    public Book() {
    }

    public Book(String title, Integer anio, Integer copies, Integer borrowedCopies, Integer remainingCopies, Boolean active, Author author, Publisher publisher) {
        this.title = title;
        this.anio = anio;
        this.copies = copies;
        this.borrowedCopies = borrowedCopies;
        this.remainingCopies = remainingCopies;
        this.active = active;
        this.author = author;
        this.publisher = publisher;
    }

    public Book(Long ISBN, String title, Integer anio, Integer copies, Integer borrowedCopies, Integer remainingCopies, Boolean active, Author author, Publisher publisher) {
        this.ISBN = ISBN;
        this.title = title;
        this.anio = anio;
        this.copies = copies;
        this.borrowedCopies = borrowedCopies;
        this.remainingCopies = remainingCopies;
        this.active = active;
        this.author = author;
        this.publisher = publisher;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Integer getBorrowedCopies() {
        return borrowedCopies;
    }

    public void setBorrowedCopies(Integer borrowedCopies) {
        this.borrowedCopies = borrowedCopies;
    }

    public Integer getRemainingCopies() {
        return remainingCopies;
    }

    public void setRemainingCopies(Integer remainingCopies) {
        this.remainingCopies = remainingCopies;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", anio=" + anio +
                ", copies=" + copies +
                ", borrowedCopies=" + borrowedCopies +
                ", remainingCopies=" + remainingCopies +
                ", active=" + active +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
