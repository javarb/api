package co.org.osso.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final CustomerService customerService;
    private final BookService bookService;

    BookController(CustomerService customerService, BookService bookService){
        this.customerService = customerService;
        this.bookService = bookService;
    }

    @GetMapping("/customer")
    public List getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book postData(
            @RequestBody Book book
    ) {
        return bookService.createBook(book);
    }

    @GetMapping("/book/{id}")
    public Book getData(@PathVariable("id") String id) {
        return bookService.getBook(id);
    }

}
