package com.ghanshyam.Movies.API.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findBySeriesId(Long seriesId);
}
