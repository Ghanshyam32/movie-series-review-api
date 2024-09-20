package com.ghanshyam.Movies.API.impl;

import com.ghanshyam.Movies.API.movie.Movie;
import com.ghanshyam.Movies.API.movie.MovieRepository;
import com.ghanshyam.Movies.API.movie.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImp implements MovieService {

//    List<Movie> movies = new ArrayList<>();

    MovieRepository movieRepository;

    public MovieServiceImp(MovieRepository movies) {
        this.movieRepository = movies;
    }

    Long id = 1L;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public void addMovie(Movie movie) {
        movie.setId(id++);
        movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long id) {
//        for (Movie movie : movies) {
//            if (movie.getId().equals(id)) {
//                return movie;
//            }
//        }

        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Movie> deleteMovieById(Long id) {
//        for (Movie movie : movies) {
//            if (movie.getId().equals(id)) {
//                movies.remove(movie);
//                return movie;
//            }
//        }
//        return null;
        Optional<Movie> movie = movieRepository.findById(id);
        movieRepository.deleteById(id);
        return movie;
    }

    @Override
    public void updateMovieById(Long id, Movie updatedData) {
        Optional<Movie> movies = movieRepository.findById(id);
        if (movies.isPresent()) {
            Movie movie = movies.get();
            movie.setTitle(updatedData.getTitle());
            movie.setGenre(updatedData.getGenre());
            movie.setRating(updatedData.getRating());
            movie.setRelease_year(updatedData.getRelease_year());
            movieRepository.save(movie);
        }
    }
}