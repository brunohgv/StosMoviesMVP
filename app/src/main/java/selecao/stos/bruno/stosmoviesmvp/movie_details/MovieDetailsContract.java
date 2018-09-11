package selecao.stos.bruno.stosmoviesmvp.movie_details;

import java.util.List;

import selecao.stos.bruno.stosmoviesmvp.data.entities.Movie;

public interface MovieDetailsContract {
    interface Model {
        interface OnFinishedListener {
            void onFinished(Movie movie);

            void onFailure(Throwable t);
        }
        void getMovie(MovieDetailsContract.Model.OnFinishedListener onFinishedListener, int id);
    }
    interface View {
        void setDataToView(String title, String description, String imageUrl);
        void onResponseFailure(Throwable t);
        void showProgress();
        void hideProgress();
    }
    interface Presenter {
        void fetchData(int id);
    }
}
