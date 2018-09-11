package selecao.stos.bruno.stosmoviesmvp.movie_details;

import android.widget.ProgressBar;

import selecao.stos.bruno.stosmoviesmvp.data.entities.Movie;

public class MovieDetailsPresenter implements MovieDetailsContract.Presenter, MovieDetailsContract.Model.OnFinishedListener{

    private Movie movie;
    private MovieDetailsContract.Model model;
    private MovieDetailsContract.View view;

    public MovieDetailsPresenter(MovieDetailsContract.View view) {
        this.view = view;
        this.model = new MovieDetailsModel();
    }

    @Override
    public void fetchData(int id) {
        view.showProgress();
        model.getMovie(this, id);
    }

    @Override
    public void onFinished(Movie movie) {
        this.movie = movie;
        view.setDataToView(movie.getTitle(), movie.getDescription(), movie.getImageURL());
        view.hideProgress();
    }

    @Override
    public void onFailure(Throwable t) {
        view.hideProgress();
        view.onResponseFailure(t);
    }
}
