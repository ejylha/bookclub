package com.bookclub.model;

public class Book {

    private String isbn;
    private String title;
    private String authorName;
    private int coverId;

    // Default constructor
    public Book() {
    }

    // Parameterized constructor
    public Book(String isbn, String title, String authorName, int coverId2) {
        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
        this.coverId = coverId2;
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getCoverId() {
        return coverId;
    }

    public void setCoverId(int coverId) {
        this.coverId = coverId;
    }

    // toString() method
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", coverId='" + coverId + '\'' +
                '}';
    }
}
