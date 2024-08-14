package com.ce.fisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ce.fisa.model.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	@Query("SELECT AVG(r.reRating) FROM Review r WHERE r.partnerId.partnerId = :partnerId")
    Double findAverageRatingByPartnerId(@Param("partnerId") Long partnerId);
	

}
