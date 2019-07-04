package com.josancamon19.mvpmoviesapi.movies_list;

import com.josancamon19.mvpmoviesapi.models.Movie;

import java.util.List;

public interface MoviesInteractor {

    void setMovies(List<Movie> movies);

    void onErrorLoadingMovies(Throwable t);

    void onLoadingCompleted(boolean moviesLoaded);


}
