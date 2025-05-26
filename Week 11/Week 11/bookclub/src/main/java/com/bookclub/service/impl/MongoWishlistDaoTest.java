package main.java.com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.mockito.Mockito.*;

public class MongoWishlistDaoTest {

    @Test
    public void addCallsMongoTemplateSave() {
        MongoTemplate mockTemplate = mock(MongoTemplate.class);
        MongoWishlistDao dao = new MongoWishlistDao();

        dao.setMongoTemplate(mockTemplate);

        WishlistItem item = new WishlistItem();
        dao.add(item);

        verify(mockTemplate, times(1)).save(item);
    }
}
