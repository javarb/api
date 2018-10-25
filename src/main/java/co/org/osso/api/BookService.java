package co.org.osso.api;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    private final Map<Integer, Book> bookCache = new HashMap<>();
    private int id;

    public Book createBook(Book book) {
        book.setBookID(id++);
        bookCache.put(book.getBookID(), book);
        return book;

    }

    /**
     * @param id
     * @return - An existent book (book exists)
     * - An empty book (book doesn't exists)
     */
    public Book getBook(Integer id) {
        return bookCache.getOrDefault(id, new Book());

    }

}

class Book {

    Integer bookID;
    String title;
    String year;

    public void setBookID(Integer id) {
        this.bookID = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

}