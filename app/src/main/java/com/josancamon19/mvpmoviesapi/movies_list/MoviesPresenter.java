package com.josancamon19.mvpmoviesapi.movies_list;

import com.josancamon19.mvpmoviesapi.models.MoviesResponse;
import com.josancamon19.mvpmoviesapi.network.MoviesService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MoviesPresenter {
    private MoviesInteractor interactor;
    private CompositeDisposable disposable = new CompositeDisposable();

    MoviesPresenter(MoviesInteractor interactor) {
        this.interactor = interactor;
        setMovies("popular");
    }

    public void setMovies(String category) {
        disposable.clear();
        MoviesService.getInstance()
                .getPopularMovies(category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable()
                .subscribe(new Observer<MoviesResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(MoviesResponse moviesResponse) {
                        interactor.setMovies(moviesResponse.getResults());
                    }

                    @Override
                    public void onError(Throwable e) {
                        interactor.onErrorLoadingMovies(e);
                    }

                    @Override
                    public void onComplete() {
                        interactor.onLoadingCompleted(true);
                    }
                });
    }

    void clearDisposables() {
        disposable.clear();
    }
}
