
package io.ong.com.services;

import java.util.Optional;
import io.ong.com.domain.Book;
import io.ong.com.domain.Review;
import io.ong.com.repositories.BookRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import io.ong.com.repositories.ReviewRepositorie;
import org.springframework.stereotype.Service;

@Service
public class ReviewService
{
    @Autowired
    ReviewRepositorie reviewRepositorie;
    @Autowired
    BookRepositorie bookRepositorie;
    
    public Review createReview(final Long bookId, final Review review) {
        final Optional<Book> oBook = (Optional<Book>)this.bookRepositorie.findById(bookId);
        if (!oBook.isPresent()) {
            return null;
        }
        final Book book = oBook.get();
        review.setBook(book);
        return (Review)this.reviewRepositorie.save(review);
    }
}