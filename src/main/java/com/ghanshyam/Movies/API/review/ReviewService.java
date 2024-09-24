package com.ghanshyam.Movies.API.review;


import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long seriesId);

    public boolean addReview(Long seriesId, Review review);
}