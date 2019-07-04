package com.josancamon19.mvpmoviesapi.models;

import java.util.List;

public class MoviesResponse {

    private int page;
    private List<Movie> results;

    public MoviesResponse(int page, List<Movie> results) {
        this.page = page;
        this.results = results;
    }

    public MoviesResponse() {

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
