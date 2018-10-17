package co.org.osso.api;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    Map<String, Book> mapBooks = new HashMap<>();
    int id;

    public Book createBook(Book book) {
        book.setBookID(""+id++);
        mapBooks.put(book.getBookID(), book);
        return book;
    }

    public Book getBook(String id) {
        if (mapBooks.get(id) != null){
            return mapBooks.get(id);
        } else {
            return new Book();
        }
    }
}

class Book{
    String bookID;
    String title;
    String year;

    public void setBookID(String ID){
        this.bookID = ID;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setYear(String year){
        this.year = year;
    }

    public String getBookID(){ return bookID; }

    public String getTitle(){ return title; }

    public String getYear(){ return year; }


}