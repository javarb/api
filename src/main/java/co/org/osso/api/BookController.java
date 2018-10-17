package co.org.osso.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookService bookService;

    @GetMapping("/customer")
    public List getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/book")
    public String printForm() {
        return "index";
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
        //System.out.println(id);
        return bookService.getBook(id);
    }

}
