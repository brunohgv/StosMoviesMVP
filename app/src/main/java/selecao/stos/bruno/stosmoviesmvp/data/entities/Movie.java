package selecao.stos.bruno.stosmoviesmvp.data.entities;

public class Movie {

    private int id;
    private String title;
    private String description;
    private String imageCover;
    private String imageURL;

    public Movie(int id, String title, String description, String imageCover, String imageURL) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageCover = imageCover;
        this.imageURL = imageURL;
    }

    public Movie(String title, String imageURL) {
        this.title = title;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageCover() {
        return imageCover;
    }

    public void setImageCover(String imageCover) {
        this.imageCover = imageCover;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageCover='" + imageCover + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
