package co.org.osso.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody final Book book) {
        return bookService.createBook(book);

    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        return bookService.getBook(id);

    }

}
