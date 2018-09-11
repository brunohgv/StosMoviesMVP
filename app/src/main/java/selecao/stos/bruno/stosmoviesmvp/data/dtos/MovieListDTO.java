package selecao.stos.bruno.stosmoviesmvp.data.dtos;

public class MovieListDTO {

    private String title;
    private String cover;

    public MovieListDTO(String title, String cover) {
        this.title = title;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
