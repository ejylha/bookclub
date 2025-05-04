package com.bookclub.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookclub.service.dao.WishlistDao;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    private WishlistDao wishlistDao;

    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    // 1. Show wishlist items
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist(Model model) {
        List<Wishlistitem> wishlist = wishlistDao.list();
        model.addAttribute("wishlist", wishlist);
        return "wishlist/list"; // points to templates/wishlist/list.html
    }

    // 2. Show form to add new wishlist item
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new Wishlistitem());
        return "wishlist/new"; // points to templates/wishlist/new.html
    }

    // 3. Handle POST form submission
    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid Wishlistitem wishlistItem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "wishlist/new"; // show form again if errors
        }
        wishlistDao.add(wishlistItem);
        return "redirect:/wishlist";
    }
}
