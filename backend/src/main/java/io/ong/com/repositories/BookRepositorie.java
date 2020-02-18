
package io.ong.com.repositories;

import org.springframework.stereotype.Repository;
import io.ong.com.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepositorie extends JpaRepository<Book, Long>{
}