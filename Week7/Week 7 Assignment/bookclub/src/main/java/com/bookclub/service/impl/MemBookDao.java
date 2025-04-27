package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

import java.util.ArrayList;
import java.util.List;

public class MemBookDao implements BookDao {

    private List<Book> books;

    public MemBookDao() {
        books = new ArrayList<>();

        books.add(new Book(
                "978-0132350884",
                "Clean Code",
                "A Handbook of Agile Software Craftsmanship",
                464,
                List.of("Robert C. Martin")));
        books.add(new Book(
                "978-0201633610",
                "Design Patterns",
                "Elements of Reusable Object-Oriented Software",
                395,
                List.of("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides")));
        books.add(new Book(
                "978-0321125217",
                "Refactoring",
                "Improving the Design of Existing Code",
                431,
                List.of("Martin Fowler")));
        books.add(new Book(
                "978-0134494166",
                "Effective Java",
                "Best practices guide for Java developers",
                416,
                List.of("Joshua Bloch")));
        books.add(new Book(
                "978-1617294945",
                "Spring in Action",
                "Comprehensive guide to Spring framework",
                600,
                List.of("Craig Walls")));
    }

    // Implementing the list() method
    @Override
    public List<Book> list() {
        return new ArrayList<>(books); // Return a copy of the books list
    }

    // Implementing the find() method
    @Override
    public Book find(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book; // Return the book if ISBN matches
            }
        }
        return null; // Return null if no book matches the ISBN
    }
}
