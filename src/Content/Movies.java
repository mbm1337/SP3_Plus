package Content;
public class Movies {
    int id;
    private String title;
    private int year;
    private float rating;

    String genre;
    public Movies(int id, String title, int year, String genre , float rating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public float getRating() {
        return rating;
    }
    public String getGenre() {
        return genre;
    }
}