package main.java.com.bookclub.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WishlistItemTest {

    @Test
    public void toStringContainsAllFields() {
        WishlistItem item = new WishlistItem();
        item.setId("1");
        item.setIsbn("1234567890");
        item.setTitle("Test Book");
        item.setUsername("testuser");

        String result = item.toString();

        assertTrue(result.contains("1234567890"));
        assertTrue(result.contains("Test Book"));
        assertTrue(result.contains("testuser"));
    }
}
