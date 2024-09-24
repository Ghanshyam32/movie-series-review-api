package com.ghanshyam.Movies.API.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series/{seriesId}")
public class ReviewsController {

    private ReviewService reviewService;

    public ReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long seriesId) {
        return new ResponseEntity<>(reviewService.getAllReviews(seriesId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long seriesId, @RequestBody Review review) {
        boolean r = reviewService.addReview(seriesId, review);
        if (r) {
            return new ResponseEntity<>("Review Added", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review can't be Added", HttpStatus.NOT_FOUND);
        }
    }
}