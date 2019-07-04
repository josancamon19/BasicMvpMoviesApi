package com.josancamon19.mvpmoviesapi.movies_list;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.josancamon19.mvpmoviesapi.R;
import com.josancamon19.mvpmoviesapi.databinding.ActivityMainBinding;
import com.josancamon19.mvpmoviesapi.models.Movie;

import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements MoviesInteractor {

    private MoviesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        presenter = new MoviesPresenter(this);
        binding.setPresenter(presenter);
    }

    @Override
    public void setMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            Timber.d(movie.getTitle());
        }
    }

    @Override
    public void onErrorLoadingMovies(Throwable t) {
        Timber.e(t);
    }

    @Override
    public void onLoadingCompleted(boolean moviesLoaded) {
        Timber.d("Movies Loading Completed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.clearDisposables();
    }

}
