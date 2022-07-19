package com.poe.TpBiblio.api;

import com.poe.TpBiblio.business.Book;
import com.poe.TpBiblio.business.service.CrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class BookController {

    @Autowired
    CrmService crmService;

    @GetMapping("books")
    public List<Book> getAll() {
        return crmService.getAllBooks();
    }

    @PostMapping("books")
    public void createBook(@RequestBody Book book)
    {
        crmService.addBook(book);
    }

    @GetMapping("books/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable("id") Long id) {

        Optional<Book> b = crmService.findBook(id);

        if (b.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(b.get());

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}