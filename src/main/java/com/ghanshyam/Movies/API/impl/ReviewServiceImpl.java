package com.ghanshyam.Movies.API.impl;

import com.ghanshyam.Movies.API.review.Review;
import com.ghanshyam.Movies.API.review.ReviewRepository;
import com.ghanshyam.Movies.API.review.ReviewService;
import com.ghanshyam.Movies.API.series.Series;
import com.ghanshyam.Movies.API.series.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;
    SeriesService seriesService;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, SeriesService seriesService) {
        this.reviewRepository = reviewRepository;
        this.seriesService = seriesService;
    }

    @Override
    public List<Review> getAllReviews(Long seriesId) {
        List<Review> reviews = reviewRepository.findBySeriesId(seriesId);
        return reviews;
    }

    @Override
    public boolean addReview(Long seriesId, Review review) {
        Series series = seriesService.getSeriesById(seriesId);
        if (series != null) {
            review.setSeries(series);
            reviewRepository.save(review);
            return true;
        }
        else{
            return false;
        }
    }
}