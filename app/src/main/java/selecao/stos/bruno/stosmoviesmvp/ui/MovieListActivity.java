package selecao.stos.bruno.stosmoviesmvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import selecao.stos.bruno.stosmoviesmvp.movie_list.IMovieListView;
import selecao.stos.bruno.stosmoviesmvp.R;
import selecao.stos.bruno.stosmoviesmvp.movie_list.MovieListAdapter;
import selecao.stos.bruno.stosmoviesmvp.movie_list.MovieListPresenter;

public class MovieListActivity extends AppCompatActivity implements IMovieListView{

    private MovieListPresenter presenter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        presenter = MovieListPresenter.getInstance();

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_movie_list);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MovieListAdapter(presenter);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void navigateToMovieDetail() {

    }
}
