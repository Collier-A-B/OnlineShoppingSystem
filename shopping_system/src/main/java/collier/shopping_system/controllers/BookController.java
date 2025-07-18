package collier.shopping_system.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import collier.shopping_system.models.BookItem;
import collier.shopping_system.repositories.BookRepository;

@RestController
@RequestMapping(path = "/bookInventory")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    /**
     * Post Requests
     */
    @PostMapping(path = "/addBook")
    public ResponseEntity<String> addBook(@Validated @RequestBody BookItem newBook, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("Input Validation Failed: " + bindingResult.getAllErrors(),
                        HttpStatus.BAD_REQUEST);
            }
            bookRepository.save(newBook);
        } catch (Exception e) {
            return new ResponseEntity<>("Unknown Error Has Occured: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Book Added Successfully", HttpStatus.CREATED);
    }

    /**
     * Get Requests
     */

    @GetMapping(path = "/getAllBooks")
    public ResponseEntity<List<BookItem>> getAllBooks() {
        try {
            List<BookItem> returnedBooks = (List<BookItem>) bookRepository.findAll();
            HttpStatus status;
            if(returnedBooks.isEmpty()) {
                status = HttpStatus.NOT_FOUND;
            } else {
                status = HttpStatus.OK;
            }
            return new ResponseEntity<>(returnedBooks, status);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
