package com.josancamon19.mvpmoviesapi.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesService {
    public static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    public static final String PARAMS_URL = "?api_key=5b457fd223b36746a494b0f20be527db&language=en-US&page=1";

    public static MoviesApi sInstance;

    public static MoviesApi getInstance() {
        if (sInstance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            sInstance = retrofit.create(MoviesApi.class);
        }
        return sInstance;
    }

}
