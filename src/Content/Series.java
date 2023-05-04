package Content;
public class Series{
    int id;
    private String title;
    private String genre;
    private String year;
    private float rating;
    private String season;
    private String episode;

    public Series(int id,String title,String year,String genre,float rating,String episode){
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
        this.episode = episode;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public String getYear() {
        return year;
    }
    public float getRating() {
        return rating;
    }
}
