package selecao.stos.bruno.stosmoviesmvp.movie_details;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import selecao.stos.bruno.stosmoviesmvp.api.ApiClient;
import selecao.stos.bruno.stosmoviesmvp.api.ApiInterface;
import selecao.stos.bruno.stosmoviesmvp.data.entities.Movie;

public class MovieDetailsModel implements MovieDetailsContract.Model {

    @Override
    public void getMovie(final OnFinishedListener onFinishedListener, int id) {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<Movie> call = apiService.getMovieDetails(id);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();
                Log.d("Body", response.body().toString());
                onFinishedListener.onFinished(movie);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }

}
