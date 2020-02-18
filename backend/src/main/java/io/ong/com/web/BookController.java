
package io.ong.com.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import io.ong.com.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import io.ong.com.payload.BookSearching;
import org.springframework.beans.factory.annotation.Autowired;
import io.ong.com.services.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/api/book" })
public class BookController
{
    @Autowired
    BookService bookService;
    
    @GetMapping({ "/all" })
    public ResponseEntity<Page<Book>> getBookAll(@Valid @RequestBody final BookSearching bookSearching, final BindingResult result) {
        Page<Book> books = this.bookService.findAll(bookSearching.getPage(), bookSearching.getSize());
        return new ResponseEntity<Page<Book>>(books, HttpStatus.OK);
    }
    
    @GetMapping({ "/{bookId}" })
    public ResponseEntity<?> getBookById(@PathVariable final Long bookId) {
        Book book = this.bookService.getBookById(bookId);
        return new ResponseEntity<Book>(book,HttpStatus.OK);
    }
    
    @PostMapping({ "/Create" })
    public ResponseEntity<?> createBook(@Valid @RequestBody final Book book, final BindingResult result) {
        final Book newBook = this.bookService.createBook(book);
        return new ResponseEntity<Book>(newBook, HttpStatus.CREATED);
    }
    
    @PostMapping({ "/update" })
    public ResponseEntity<?> updateBook(@Valid @RequestBody final Book book, final BindingResult result) {
        final Book newBook = this.bookService.createBook(book);
        return new ResponseEntity<Book>(newBook,HttpStatus.OK);
    }
}