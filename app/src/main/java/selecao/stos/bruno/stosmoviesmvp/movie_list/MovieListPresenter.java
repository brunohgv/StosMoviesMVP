package selecao.stos.bruno.stosmoviesmvp.movie_list;

import java.util.ArrayList;
import java.util.List;

import selecao.stos.bruno.stosmoviesmvp.data.entities.Movie;

public class MovieListPresenter implements MovieListContract.Presenter, MovieListContract.Model.OnFinishedListener{

    private List<Movie> movieList;
    private static MovieListPresenter instance;
    private MovieListContract.Model model;
    private MovieListContract.View view;


    public MovieListPresenter(MovieListContract.View view) {
        this.movieList = new ArrayList<>();
//        for (int i = 0 ; i < 10 ; i++) {
//            Movie movie = new Movie("Filme " + i, "https://i.ytimg.com/vi/IsdBwnlEYF0/hqdefault.jpg?sqp=-oaymwEWCKgBEF5IWvKriqkDCQgBFQAAiEIYAQ==&rs=AOn4CLCQKioLMKuPMVH7bcjX9TBueyh9Zg");
//            movieList.add(movie);
//        }
        this.view = view;
        model = new MovieListModel();
    }

    @Override
    public void onBindMovieListRowViewAtPosition(MovieListContract.RowView rowView, int position){
        Movie movie = movieList.get(position);
        rowView.setTitle(movie.getTitle());
        rowView.setCoverImage(movie.getImageURL());
        rowView.setCardAction();
        rowView.setId(movie.getId());
    }

    @Override
    public int getMovieListRowsCount() {
        return movieList.size();
    }

    @Override
    public void fetchData() {
        model.getMovieList(this);
    }

    @Override
    public void onFinished(List<Movie> movieArrayList) {
        movieList.addAll(movieArrayList);
        view.setDataToRecyclerView();
    }

    @Override
    public void onFailure(Throwable t) {
        view.onResponseFailure(t);
    }
}
