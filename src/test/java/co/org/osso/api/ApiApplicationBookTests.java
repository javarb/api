package co.org.osso.api;

import org.junit.Assert;
import org.junit.Test;

public class ApiApplicationBookTests {

    private BookService BookServiceTarget = new BookService();

    @Test
    public void checkBookServiceGetBookWhenNull() {
        Book book = BookServiceTarget.getBook(0);
        Assert.assertEquals(null, book.getBookID());
    }

}
