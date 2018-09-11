package selecao.stos.bruno.stosmoviesmvp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import selecao.stos.bruno.stosmoviesmvp.R;
import selecao.stos.bruno.stosmoviesmvp.movie_list.MovieListAdapter;
import selecao.stos.bruno.stosmoviesmvp.movie_list.MovieListContract;
import selecao.stos.bruno.stosmoviesmvp.movie_list.MovieListPresenter;

public class MovieListActivity extends AppCompatActivity implements MovieListContract.View{

    private MovieListPresenter presenter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        presenter = new MovieListPresenter(this);

        progressBar = findViewById(R.id.movie_list_progress_bar);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_movie_list);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        presenter.fetchData();
//        setDataToRecyclerView();
    }

    @Override
    public void navigateToMovieDetail(int movieId) {
        Intent intent = new Intent(getBaseContext(), MovieDetailActivity.class);
        intent.putExtra("id", movieId);
        startActivity(intent);
    }

    @Override
    public void setDataToRecyclerView() {
        mAdapter = new MovieListAdapter(presenter);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResponseFailure(Throwable t) {
        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

}
