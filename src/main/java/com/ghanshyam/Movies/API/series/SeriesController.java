package com.ghanshyam.Movies.API.series;

import com.ghanshyam.Movies.API.impl.SeriesServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {

    private final SeriesServiceImpl seriesService;

    // Constructor Injection
    public SeriesController(SeriesServiceImpl seriesService) {
        this.seriesService = seriesService;
    }

    // Fetch all series
    @GetMapping
    public ResponseEntity<List<Series>> findAll() {
        return ResponseEntity.ok(seriesService.findAll());
    }

    // Add a new series
    @PostMapping
    public ResponseEntity<String> addSeries(@RequestBody Series series) {
        seriesService.addSeries(series);
        return new ResponseEntity<>("Series added successfully", HttpStatus.CREATED);
    }

    // Fetch a series by its ID (with reviews included)
    @GetMapping("/{id}")
    public ResponseEntity<Series> getSeriesById(@PathVariable long id) {
        Series series = seriesService.getSeriesById(id);
        if (series != null) {
            return new ResponseEntity<>(series, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a series by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSeriesById(@PathVariable long id) {
        Series series = seriesService.getSeriesById(id);
        if (series != null) {
            seriesService.deleteSeriesById(id);
            return new ResponseEntity<>("Series deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Series not found", HttpStatus.NOT_FOUND);
    }

    // Update an existing series by its ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateSeriesById(@RequestBody Series updatedSeries, @PathVariable Long id) {
        Series existingSeries = seriesService.getSeriesById(id);
        if (existingSeries != null) {
            seriesService.updateMovieById(updatedSeries, id);
            return new ResponseEntity<>("Series updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Series not found", HttpStatus.NOT_FOUND);
    }
}
