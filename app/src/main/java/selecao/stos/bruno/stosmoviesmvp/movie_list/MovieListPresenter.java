package selecao.stos.bruno.stosmoviesmvp.movie_list;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import selecao.stos.bruno.stosmoviesmvp.data.entities.Movie;

public class MovieListPresenter implements IMovieListPresenter {

    private List<Movie> movieList;
    private static MovieListPresenter instance;

    public static MovieListPresenter getInstance () {
        if (MovieListPresenter.instance == null) {
            instance = new MovieListPresenter();
        }
        return instance;
    }

    public MovieListPresenter() {
        this.movieList = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            Movie movie = new Movie("Filme " + i, "https://i.ytimg.com/vi/IsdBwnlEYF0/hqdefault.jpg?sqp=-oaymwEWCKgBEF5IWvKriqkDCQgBFQAAiEIYAQ==&rs=AOn4CLCQKioLMKuPMVH7bcjX9TBueyh9Zg");
            movieList.add(movie);
        }
    }

    @Override
    public void onBindMovieListRowViewAtPosition(IMovieListRowView rowView, int position){
        Movie movie = movieList.get(position);
        rowView.setTitle(movie.getTitle());
        rowView.setCoverImage(movie.getImageURL());
        rowView.setCardAction();
    }

    @Override
    public int getMovieListRowsCount() {
        return movieList.size();
    }

}
