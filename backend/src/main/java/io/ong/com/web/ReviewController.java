
package io.ong.com.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import io.ong.com.domain.Review;
import org.springframework.web.bind.annotation.GetMapping;
import io.ong.com.domain.Book;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import io.ong.com.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import io.ong.com.services.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/api/review" })
public class ReviewController
{
    @Autowired
    BookService bookService;
    @Autowired
    ReviewService reviewService;
    
    @GetMapping({ "/{bookId}" })
    public ResponseEntity<?> getBookById(@PathVariable final Long bookId) {
        final Book book = this.bookService.getBookById(bookId);
        if (book == null) {
            return new ResponseEntity<List<Review>>( new ArrayList<Review>(), HttpStatus.OK);
        }
        return new ResponseEntity<List<Review>>( book.getReview(), HttpStatus.OK);
    }
    
    @PostMapping({ "/{bookId}/Create" })
    public ResponseEntity<?> CreateReview(@PathVariable final Long bookId, @Valid @RequestBody final Review review, final BindingResult result) {
        final Review rtReview = this.reviewService.createReview(bookId, review);
        return new ResponseEntity<Review>(rtReview,HttpStatus.OK);
    }
}