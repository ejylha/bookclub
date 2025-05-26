package main.java.com.bookclub.web;

import com.bookclub.dao.WishlistDao;
import com.bookclub.model.WishlistItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json")
@CrossOrigin(origins = "*")
public class WishlistRestController {

    private WishlistDao wishlistDao;

    @Autowired
    public void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    // Returns wishlist for the authenticated user
    @GetMapping
    public List<WishlistItem> showWishlist(Authentication authentication) {
        String username = authentication.getName(); // Get the current user's username
        return wishlistDao.list(username); // Pass it into the DAO
    }

    // Returns a specific wishlist item by ID
    @GetMapping("/{id}")
    public WishlistItem findById(@PathVariable String id) {
        return wishlistDao.find(id);
    }
}
