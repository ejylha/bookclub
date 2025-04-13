package com.bookclub.service.dao;

import com.bookclub.dao.BookDao.java;
import com.bookclub.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemBookDao implements BookDao {

    private List<Book> books;

    public MemBookDao() {
        books = new ArrayList<>();

        books.add(new Book(
                "9780134685991",
                "Effective Java",
                "A best practices guide for writing high-quality Java code.",
                416,
                Arrays.asList("Joshua Bloch")));

        books.add(new Book(
                "9781491950357",
                "Learning Spring Boot",
                "A hands-on guide to developing modern web applications using Spring Boot.",
                400,
                Arrays.asList("Greg L. Turnquist")));

        books.add(new Book(
                "9780132350884",
                "Clean Code",
                "A handbook of agile software craftsmanship.",
                464,
                Arrays.asList("Robert C. Martin")));

        books.add(new Book(
                "9781617294945",
                "Spring in Action",
                "Covers Spring Framework fundamentals with hands-on examples.",
                520,
                Arrays.asList("Craig Walls")));

        books.add(new Book(
                "9780201616224",
                "The Pragmatic Programmer",
                "Your journey to mastery as a software developer.",
                352,
                Arrays.asList("Andrew Hunt", "David Thomas")));
    }

    @Override
    public List<Book> list() {
        return books;
    }

    @Override
    public Book find(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
