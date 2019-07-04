package com.josancamon19.mvpmoviesapi.network;

import com.josancamon19.mvpmoviesapi.models.MoviesResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.josancamon19.mvpmoviesapi.network.MoviesService.PARAMS_URL;


public interface MoviesApi {

    @GET("{category}" + PARAMS_URL)
    public Flowable<MoviesResponse> getPopularMovies(@Path("category") String category);
}
