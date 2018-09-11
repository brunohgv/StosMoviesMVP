package selecao.stos.bruno.stosmoviesmvp.movie_list;

public interface IMovieListPresenter<T> {

    void onBindMovieListRowViewAtPosition(IMovieListRowView rowView, int position);
    int getMovieListRowsCount();
    void fetchData();

}
