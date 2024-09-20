package com.ghanshyam.Movies.API.movie;


import jakarta.persistence.*;

@Entity
@Table(name = "Movie Table ")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String title;
    public int release_year;
    public String genre;
    public float rating;


    public Movie(long id, String title, String genre, float rating, int release_year) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.release_year = release_year;
    }

    public Movie(){

    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
}
