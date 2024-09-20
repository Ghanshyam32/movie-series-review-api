package com.ghanshyam.Movies.API.series;

import java.util.List;

public interface SeriesService {

    List<Series> findAll();

    void addSeries(Series series);

    Series getSeriesById(long id);

    void deleteSeriesById(long id);

    void updateMovieById(Series updatedSeries, Long id);
}
