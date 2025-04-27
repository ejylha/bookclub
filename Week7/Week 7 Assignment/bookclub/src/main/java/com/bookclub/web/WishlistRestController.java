package main.java.com.bookclub.web;

import com.bookclub.dao.WishlistDao;
import com.bookclub.model.Wishlistitem;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<WishlistItem> showWishlist() {
        return wishlistDao.list();
    }

    @GetMapping("/{id}")
    public WishlistItem findById(@PathVariable String id) {
        return wishlistDao.find(id);
    }
}
