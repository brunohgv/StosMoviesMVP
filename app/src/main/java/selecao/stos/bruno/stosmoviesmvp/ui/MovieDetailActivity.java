package selecao.stos.bruno.stosmoviesmvp.ui;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import selecao.stos.bruno.stosmoviesmvp.R;
import selecao.stos.bruno.stosmoviesmvp.movie_details.MovieDetailsContract;
import selecao.stos.bruno.stosmoviesmvp.movie_details.MovieDetailsPresenter;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetailsContract.View{

    ImageView coverImageView;
    TextView titleTextView;
    TextView descriptionTextView;
    ProgressBar progressBar;

    MovieDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);

        presenter = new MovieDetailsPresenter(this);

        coverImageView = findViewById(R.id.movie_detail_image);
        titleTextView = findViewById(R.id.movie_detail_title);
        descriptionTextView = findViewById(R.id.movie_detail_description);
        progressBar = findViewById(R.id.progress_bar);

        presenter.fetchData(id);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    @Override
    public void setDataToView(String title, String description, String imageUrl) {
        titleTextView.setText(title);
        descriptionTextView.setText(description);
        Picasso.with(this).load(imageUrl).into(coverImageView);
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
