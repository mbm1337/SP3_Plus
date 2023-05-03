package Content;

import Util.DBConnector;
import Util.TextUI;
import Util.User;

import java.util.ArrayList;

public class Series{
    int id;
    private String title;
    private String genre;

    private String year;
    private float rating;
    private String season;
    private String episode;
    User currentUser;
    TextUI ui = new TextUI();

    DBConnector dbc;

    ArrayList<Series> series;


    public Series(){

    }

    public Series(int id,String title,String year,String genre,float rating,String episode){
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
        this.episode = episode;

    }

    public void seriesMenu(User user){
        currentUser = user;
        dbc = new DBConnector();
        series = dbc.readSeriesData();

        String inputSeries = ui.getUserInput("Please choose between following options;\n" +
                "1. Search for a specific series\n" +
                "2. Search for a genre and receive all series in this category\n" +
                "3. Review your list of watched movies and series\n" +
                "4. Review your list of saved movies and series");
        switch (inputSeries) {
            case "1":
                seriesSearch();
                break;
            case "2":
                genreSearch();
                break;
            case "3":
                currentUser.watchedList();
                break;
            case "4":
                currentUser.savedList();
                break;
            default:
                ui.displayMessage("This is not an option");
                seriesMenu(currentUser);
        }
    }

   public void seriesSearch(){
        String input = ui.getUserInput("Please type the desired series:");

        for (Series s : series) {
            if (input.equalsIgnoreCase(s.title)) {
                String s2 = ui.getUserInput("Choose between: 1/2\n" +
                        "1. Watch the chosen series\n" +
                        "2. Save series to your saved list");
                if (s2.equalsIgnoreCase("1")) {
                    ui.displayMessage("You are now watching " + s.title);
                    currentUser.watchedList.add(s.title);
                    ui.displayMessage("\nThank you for watching. Do you want to watch more?");

                } else if(s2.equalsIgnoreCase("2")) {
                    currentUser.savedList.add(s.title);
                    System.out.println("The series was saved on your watch list");
                }else {
                    ui.displayMessage("This is not an option");
                    seriesSearch();
                }
            }
        }
    }
    public void genreSearch(){
        String input = ui.getUserInput("Please type the desired genre:");

        for (Series s : series) {

            String [] tmpGenre = s.genre.split(".");

            for (String s2 : tmpGenre) {
                if (input.equalsIgnoreCase(s2.trim())) {
                    ui.displayMessage(title);
                }
            }
        }
        seriesSearch();
    }
}
