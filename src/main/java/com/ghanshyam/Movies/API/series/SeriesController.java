package com.ghanshyam.Movies.API.series;

import com.ghanshyam.Movies.API.impl.SeriesServiceImpl;
import com.ghanshyam.Movies.API.movie.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SeriesController {

    List<Series> series = new ArrayList<>();
    SeriesServiceImpl seriesService;

    SeriesController(SeriesServiceImpl seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping("/series")
    public ResponseEntity<List<Series>> findAll() {
        return ResponseEntity.ok(seriesService.findAll());
    }

    @PostMapping("/series")
    public ResponseEntity<String> addSeries(@RequestBody Series series) {
        seriesService.addSeries(series);
        return new ResponseEntity<>("Accepted", HttpStatus.OK);
    }

    @GetMapping("/series/{id}")
    public ResponseEntity<Series> getSeriesById(@PathVariable long id) {
        Series series1 = seriesService.getSeriesById(id);
        if (series1 != null) {
            return new ResponseEntity<>(series1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/series/{id}")
    public ResponseEntity<String> deleteSeriesById(@PathVariable long id) {
        Series series1 = seriesService.getSeriesById(id);
        if (series1 != null) {
            seriesService.deleteSeriesById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Available", HttpStatus.OK);
    }

    @PutMapping("/series/{id}")
    public ResponseEntity<String> updateMovieById(@RequestBody Series updatedSeries, @PathVariable Long id) {
        if(seriesService.getSeriesById(id)!=null){
            seriesService.updateMovieById(updatedSeries, id);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error Encountered", HttpStatus.NOT_FOUND);
    }
}
