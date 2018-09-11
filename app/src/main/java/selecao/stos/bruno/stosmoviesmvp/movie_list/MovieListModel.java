package selecao.stos.bruno.stosmoviesmvp.movie_list;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import selecao.stos.bruno.stosmoviesmvp.api.ApiClient;
import selecao.stos.bruno.stosmoviesmvp.api.ApiInterface;
import selecao.stos.bruno.stosmoviesmvp.data.entities.Movie;

public class MovieListModel implements MovieListContract.Model {

    @Override
    public void getMovieList(final OnFinishedListener onFinishedListener) {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Movie>> call = apiService.getMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                List<Movie> movies = response.body();
                Log.d("Body", response.body().toString());
                onFinishedListener.onFinished(movies);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }

}
