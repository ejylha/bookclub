package com.bookclub.service.dao;

import com.bookclub.model.Book;
import java.util.List;

public interface BookDao {
    List<Book> list();

    Book find(String isbn);
}
