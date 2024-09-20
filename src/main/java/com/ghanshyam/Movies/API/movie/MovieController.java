package com.ghanshyam.Movies.API.movie;

import com.ghanshyam.Movies.API.impl.MovieServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    public List<Movie> movies = new ArrayList<>();

    MovieServiceImp serviceImp;

    public MovieController(MovieServiceImp serviceImp) {
        this.serviceImp = serviceImp;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> findAll() {
        return ResponseEntity.ok(serviceImp.findAll());
    }

    @PostMapping("/movies")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        serviceImp.addMovie(movie);
        return new ResponseEntity<>("Added", HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = serviceImp.getMovieById(id);
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<String> deleteMovieById(@PathVariable Long id) {
        Optional<Movie> movie = serviceImp.deleteMovieById(id);
        if (movie != null) {
            return new ResponseEntity<>("Movie is deleted", HttpStatus.GONE);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Void> updateMovieById(@PathVariable Long id, @RequestBody Movie updatedData) {
        if (serviceImp.getMovieById(id) != null) {
            serviceImp.updateMovieById(id, updatedData);
            return ResponseEntity.ok().build();
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
