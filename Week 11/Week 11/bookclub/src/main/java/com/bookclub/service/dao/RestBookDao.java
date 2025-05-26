package com.bookclub.service.dao;

import com.bookclub.dao.BookDao;
import com.bookclub.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

@Repository
public class RestBookDao implements BookDao {

    private static final String API_BASE_URL = "https://openlibrary.org/search.json";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Book find(String query) {
        String url = UriComponentsBuilder.fromHttpUrl(API_BASE_URL)
                .queryParam("q", query)
                .toUriString();

        String jsonResponse = restTemplate.getForObject(url, String.class);

        JSONObject root = new JSONObject(jsonResponse);
        JSONArray docs = root.getJSONArray("docs");

        if (docs.isEmpty()) {
            return null;
        }

        JSONObject first = docs.getJSONObject(0);
        String title = first.optString("title", "Unknown Title");
        String isbn = first.has("isbn") ? first.getJSONArray("isbn").optString(0, "N/A") : "N/A";
        String author = first.has("author_name") ? first.getJSONArray("author_name").optString(0, "Unknown Author")
                : "Unknown Author";
        int coverId = first.optInt("cover_i", -1);

        return new Book(isbn, title, author, coverId);
    }
}
