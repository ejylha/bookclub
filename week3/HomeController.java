package com.bookclub.web;

import com.bookclub.impl.MemBookDao; // Import MemBookDao
import com.bookclub.model.Book; // Import Book model
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String showHome(Model model) {
        // Create an instance of MemBookDao
        MemBookDao bookDao = new MemBookDao();

        // Retrieve the list of books
        List<Book> books = bookDao.list();

        // Print books to the console for debugging
        for (Book book : books) {
            System.out.println(book.toString());
        }

        // Add the books to the model with the correct syntax
        model.addAttribute("books", books);

        // Display the index.html page
        return "index";
    }

    @GetMapping("/about")
    public String showAboutUs(Model model) {
        return "about";
    }

    @GetMapping("/contact")
    public String showContactUs(Model model) {
        return "contact";
    }

    // New method to display a specific book by ISBN
    @GetMapping("/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {
        // Assign the id to the isbn variable
        String isbn = id;
        System.out.println("Received ID: " + id); // Print ID for debugging

        // Create a new instance of MemBookDao
        MemBookDao bookDao = new MemBookDao();

        // Find the book by ISBN
        Book book = bookDao.find(isbn);

        // Print the book details for debugging
        if (book != null) {
            System.out.println(book.toString());
        } else {
            System.out.println("Book not found with ISBN: " + isbn);
        }

        // Add the book to the model with the correct syntax
        model.addAttribute("book", book);

        // Return the HTML view page
        return "monthly-books/view";
    }
}
