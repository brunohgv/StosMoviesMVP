package selecao.stos.bruno.stosmoviesmvp.movie_list;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import selecao.stos.bruno.stosmoviesmvp.data.entities.Movie;

public interface ApiInterface {

    @GET("app/filme/listar")
    Call<List<Movie>> getMovies();

    @GET("app/filme/get/{id}")
    Call<Movie> getMovieDetails(@Path("id") int id);

}
