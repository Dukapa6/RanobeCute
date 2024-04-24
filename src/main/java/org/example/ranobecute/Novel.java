package org.example.ranobecute;

public class Novel {
    private int idNovel;
    private String title;
    private String author;
    private String genre;
    private String description;
    private String status;
    private String image;
    private String type;
    private String year;

    public Novel() {
    }

    public Novel(String title, String author, String genre, String description, String status, String image, String type, String year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.status = status;
        this.image = image;
        this.type = type;
        this.year = year;
    }

    public Novel(String title, String image, String type) {
        this.title = title;
        this.image = image;
        this.type = type;
    }

    public int getIdNovel() {
        return idNovel;
    }

    public void setIdNovel(int idNovel) {
        this.idNovel = idNovel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "idNovel=" + idNovel +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
