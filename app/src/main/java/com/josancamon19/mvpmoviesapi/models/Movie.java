package com.josancamon19.mvpmoviesapi.models;

import com.google.gson.annotations.SerializedName;

public class Movie {
    private int id;
    private String title;
    private String overview;
    @SerializedName("poster_path")
    private String posterPath;
    private double popularity;

    public Movie() {
    }

    public Movie(int id, String title, String overview, String posterPath, double popularity) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.posterPath = posterPath;
        this.popularity = popularity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }
}
