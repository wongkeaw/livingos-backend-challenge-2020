
package io.ong.com.services;

import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import io.ong.com.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import io.ong.com.repositories.BookRepositorie;
import org.springframework.stereotype.Service;

@Service
public class BookService
{
    @Autowired
    BookRepositorie bookRepositorie;
    
    public Page<Book> findAll(final int page, final int size) {
        final Pageable pageable = (Pageable)PageRequest.of(page, size, Sort.by(new String[] { "id" }).descending());
        return (Page<Book>)this.bookRepositorie.findAll(pageable);
    }
    
    public Book createBook(final Book book) {
        return (Book)this.bookRepositorie.save(book);
    }
    
    @Transactional
    public Book getBookById(final Long id) {
        final Optional<Book> oBook = (Optional<Book>)this.bookRepositorie.findById(id);
        if (!oBook.isPresent()) {
            return null;
        }
        final Book book = oBook.get();
        book.getReview();
        return book;
    }
}