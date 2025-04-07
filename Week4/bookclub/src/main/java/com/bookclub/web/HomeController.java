package com.bookclub.web;

import com.bookclub.dao.MemBookDao; // Import MemBookDao
import com.bookclub.model.Book; // Import Book model

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

        return "index"; // Display the index.html page
    }

    @GetMapping("/about")
    public String showAboutUs(Model model) {
        return "about";
    }

    @GetMapping("/contact")
    public String showContactUs(Model model) {
        return "contact";
    }
}
