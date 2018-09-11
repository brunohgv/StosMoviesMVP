package selecao.stos.bruno.stosmoviesmvp.movie_list;

import java.util.List;

import selecao.stos.bruno.stosmoviesmvp.data.entities.Movie;

public interface MovieListContract {
    interface Model {
        interface OnFinishedListener {
            void onFinished(List<Movie> movieArrayList);

            void onFailure(Throwable t);
        }
        void getMovieList(OnFinishedListener onFinishedListener);
    }
    interface View {
        void navigateToMovieDetail(int movieId);
        void setDataToRecyclerView();
        void onResponseFailure(Throwable t);
    }
    interface Presenter {
        void onBindMovieListRowViewAtPosition(RowView rowView, int position);
        int getMovieListRowsCount();
        void fetchData();
    }
    interface RowView {
        void setTitle(String title);
        void setCoverImage(String imageURL);
        void setCardAction();
        void setId(int id);
    }
}
