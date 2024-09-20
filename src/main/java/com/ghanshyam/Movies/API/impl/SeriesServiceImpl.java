package com.ghanshyam.Movies.API.impl;

import com.ghanshyam.Movies.API.series.Series;
import com.ghanshyam.Movies.API.series.SeriesRepository;
import com.ghanshyam.Movies.API.series.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SeriesServiceImpl implements SeriesService {

    SeriesRepository seriesRepository;

    @Autowired
    public SeriesServiceImpl(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<Series> findAll() {
        return seriesRepository.findAll();
    }

    Long id = 1L;

    @Override
    public void addSeries(Series series) {
        series.setId(id++);
        seriesRepository.save(series);
    }

    @Override
    public Series getSeriesById(long id) {
        return seriesRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSeriesById(long id) {
        seriesRepository.deleteById(id);
    }

    @Override
    public void updateMovieById(Series updatedSeries, Long id) {
        Optional<Series> series1 = seriesRepository.findById(id);
        if (series1.isPresent()) {
            Series series = series1.get();
            series.setTitle(updatedSeries.getTitle());
            series.setRating(updatedSeries.getRating());
            series.setSeasons(updatedSeries.getSeasons());
            series.setRelease_year(updatedSeries.getRelease_year());
            seriesRepository.save(series);
        }
    }
}
