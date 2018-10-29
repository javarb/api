package co.org.osso.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationBookTests {

    private BookService BookServiceTarget = new BookService();

    @Autowired
    private BookController BookControllerTarget;

    @Test
    public void checkBookServiceGetBookWhenNull() {
        Book book = BookServiceTarget.getBook(0);
        Assert.assertEquals(null, book.getBookID());
    }

    @Test
    public void checkBookControllerGetBookEqualsTo() {
        Book book = new Book();
        book.setTitle("Book in Test");
        book.setYear("1900");
        BookControllerTarget.postBook(book);
        Assert.assertEquals("1900", BookControllerTarget.getBook(0).getYear());
    }

}
