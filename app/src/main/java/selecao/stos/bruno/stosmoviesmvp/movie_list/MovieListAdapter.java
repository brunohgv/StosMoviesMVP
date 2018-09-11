package selecao.stos.bruno.stosmoviesmvp.movie_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import selecao.stos.bruno.stosmoviesmvp.R;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListViewHolder> {

    private MovieListPresenter presenter;

    public MovieListAdapter(MovieListPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_row_view, parent, false);
        return new MovieListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListViewHolder holder, int position) {
        presenter.onBindMovieListRowViewAtPosition(holder, position);
    }

    @Override
    public int getItemCount() {
        return presenter.getMovieListRowsCount();
    }
}
