package com.bookclub.service.impl;

import com.bookclub.model.Wishlistitem;
import com.bookclub.service.dao.WishlistDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void add(Wishlistitem item) {
        mongoTemplate.save(item);
    }

    @Override
    public void update(Wishlistitem item) {
        mongoTemplate.save(item);
    }

    @Override
    public boolean remove(Wishlistitem item) {
        mongoTemplate.remove(item);
        return true;
    }

    @Override
    public List<WishlistItem> list() {
        return mongoTemplate.findAll(Wishlistitem.class);
    }

    @Override
    public Wishlistitem find(String id) {
        return mongoTemplate.findById(id, Wishlistitem.class);
    }
}
