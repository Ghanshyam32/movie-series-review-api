package com.ghanshyam.Movies.API.impl;

import com.ghanshyam.Movies.API.series.Series;
import com.ghanshyam.Movies.API.series.SeriesRepository;
import com.ghanshyam.Movies.API.series.SeriesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService {

    private final SeriesRepository seriesRepository;

    public SeriesServiceImpl(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<Series> findAll() {
        return seriesRepository.findAll();
    }

    @Override
    public void addSeries(Series series) {
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
        Series series = seriesRepository.findById(id).orElse(null);
        if (series != null) {
            series.setTitle(updatedSeries.getTitle());
            series.setRelease_year(updatedSeries.getRelease_year());
            series.setSeasons(updatedSeries.getSeasons());
            seriesRepository.save(series);
        }
    }
}
