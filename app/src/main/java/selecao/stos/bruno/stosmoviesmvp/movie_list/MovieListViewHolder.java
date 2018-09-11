package selecao.stos.bruno.stosmoviesmvp.movie_list;

import android.app.Application;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import selecao.stos.bruno.stosmoviesmvp.R;
import selecao.stos.bruno.stosmoviesmvp.ui.MovieDetailActivity;

public class MovieListViewHolder extends RecyclerView.ViewHolder implements MovieListContract.RowView {

    TextView titleTextView;
    ImageView coverImageImageView;
    CardView cardView;
    MovieListContract.View viewInterface;
    private int id;

    public MovieListViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = (TextView) itemView.findViewById(R.id.card_list_movie_title);
        coverImageImageView = (ImageView) itemView.findViewById(R.id.card_list_cover_image);
        cardView = (CardView) itemView.findViewById(R.id.card_list);
    }

    @Override
    public void setTitle(String title) {
        titleTextView.setText(title);
    }

    @Override
    public void setCoverImage(String imageURL){
        Picasso.with(itemView.getContext()).load(imageURL).into(coverImageImageView);
    }

    @Override
    public void setCardAction() {
        cardView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), MovieDetailActivity.class);
                        intent.putExtra("id", id);
                        view.getContext().startActivity(intent);
                    }
                }
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
