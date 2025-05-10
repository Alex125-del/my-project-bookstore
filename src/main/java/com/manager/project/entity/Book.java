package com.manager.project.entity;
import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String genre;

    private int yearPublished;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    protected Book() {
    }


    public Book(String title, String genre, int yearPublished, Author author) {
        this.title = title;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.author = author;
    }


    public Book(Long id, String title, String genre, int yearPublished, Author author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    public Book(String title) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}


