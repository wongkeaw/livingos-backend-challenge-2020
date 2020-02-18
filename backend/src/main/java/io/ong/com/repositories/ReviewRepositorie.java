package io.ong.com.repositories;

import org.springframework.stereotype.Repository;
import io.ong.com.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReviewRepositorie extends JpaRepository<Review, Long>{
}