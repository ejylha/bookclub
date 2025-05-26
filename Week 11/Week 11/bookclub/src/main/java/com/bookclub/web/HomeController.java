package com.bookclub.web;

import com.bookclub.dao.BookOfTheMonthDao;
import com.bookclub.model.BookOfTheMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final BookOfTheMonthDao bookOfTheMonthDao;

    @Autowired
    public HomeController(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao = bookOfTheMonthDao;
    }

    @GetMapping
    public String showHome(Model model) {
        int currentMonth = LocalDate.now().getMonthValue();
        List<BookOfTheMonth> monthlyBooks = bookOfTheMonthDao.list(String.valueOf(currentMonth));
        model.addAttribute("monthlyBooks", monthlyBooks);
        return "index";
    }
}
