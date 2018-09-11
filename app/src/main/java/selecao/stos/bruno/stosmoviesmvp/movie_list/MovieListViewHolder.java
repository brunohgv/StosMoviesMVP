package selecao.stos.bruno.stosmoviesmvp.movie_list;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import selecao.stos.bruno.stosmoviesmvp.R;

public class MovieListViewHolder extends RecyclerView.ViewHolder implements IMovieListRowView {

    TextView titleTextView;
    ImageView coverImageImageView;
    CardView cardView;

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
                        showToast();
                    }
                }
        );
    }

    @Override
    public void showToast() {
        Toast.makeText(itemView.getContext(), titleTextView.getText().toString(), Toast.LENGTH_LONG).show();
    }
}
