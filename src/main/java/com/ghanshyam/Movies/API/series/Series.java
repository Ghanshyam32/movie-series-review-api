package com.ghanshyam.Movies.API.series;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ghanshyam.Movies.API.movie.Movie;
import com.ghanshyam.Movies.API.review.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    int release_year;
    int seasons;

    public Series(Long id, String title, int release_year, int seasons) {
        this.id = id;
        this.title = title;
        this.release_year = release_year;
        this.seasons = seasons;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "series", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Series(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Series() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

}
