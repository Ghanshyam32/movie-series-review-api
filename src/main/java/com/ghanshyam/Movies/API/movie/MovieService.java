package com.ghanshyam.Movies.API.movie;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    List<Movie> findAll();

    void addMovie(Movie movie);

    Movie getMovieById(Long id);

    Optional<Movie> deleteMovieById(Long id);

    void updateMovieById(Long id, Movie data);
}
