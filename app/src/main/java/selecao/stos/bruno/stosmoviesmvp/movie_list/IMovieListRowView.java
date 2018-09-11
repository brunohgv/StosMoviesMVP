package selecao.stos.bruno.stosmoviesmvp.movie_list;

import android.content.Context;

public interface IMovieListRowView {

    void setTitle(String title);
    void setCoverImage(String imageURL);
    void setCardAction();
    void showToast();

}
