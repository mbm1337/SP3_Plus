package Content;

import Util.DBConnector;
import Util.TextUI;
import Util.User;

import java.util.ArrayList;

public class Movies {
    int id;
    private String title;
    private int year;
    private float rating;
    TextUI ui = new TextUI();

    User currentUser;
    String genre;


    private ArrayList<Movies>movies;

    DBConnector dbc;

    public Movies(){

    }



    public Movies(int id, String title, int year, String genre , float rating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;

    }

    public void movieMenu(User user) {
        currentUser = user;
        dbc = new DBConnector();
        movies = dbc.readMovieData();
        String inputMovies = ui.getUserInput(
                "Please choose between following options;\n" +
                        "1. Search for a specific movie\n" +
                        "2. Search for a genre and receive all movies in this category\n" +
                        "3. Search by decade and receive all movies in a period \n" +
                        "4. Review your list of watched movies and series\n" +
                        "5. Review your list of saved movies and series");
        switch (inputMovies) {
            case "1":
                movieSearch();
                break;
            case "2":
                genreSearch();
                break;
            case "3":
                searchByYear();
                break;
            case "4":
                currentUser.watchedList();
                break;
            case "5":
                currentUser.savedList();
            default:
                movieMenu(currentUser);
        }
    }

    public void movieSearch() {

        String input = ui.getUserInput("Please type the desired movie:");

        for (Movies m : movies) {
            if (input.equalsIgnoreCase(m.title)) {
                String input2 = ui.getUserInput("Choose between: 1/2\n" +
                        "1. Watch the chosen movie\n" +
                        "2. Save movie to your saved list");
                if (input2.equalsIgnoreCase("1")) {
                    ui.displayMessage("You are now watching " + m.title);
                    currentUser.watchedList.add(m.title);
                    ui.displayMessage("\nThank you for watching. Do you want to watch more?");

                } else if (input2.equalsIgnoreCase("2")) {
                    currentUser.savedList.add(m.title);
                    ui.displayMessage("The movie was saved on your saved list.");

                } else {
                    ui.displayMessage("This is not an option");
                    movieSearch();
                }
            }
        }
    }

    public void genreSearch() {
        String input = ui.getUserInput("Please type the desired genre:");

        for (Movies m : movies) {
            String [] tmpGenre = m.genre.split(".");

            for (String s2 : tmpGenre) {
                if (input.equalsIgnoreCase(s2.trim())) {
                    ui.displayMessage(title);
                }
            }
        }
        movieSearch();
    }

    public void searchByYear() {
        ArrayList<String> yearSeach = new ArrayList<>();
        int input = Integer.parseInt(ui.getUserInput("Please type the desired decade:"));


        for (Movies m : movies) {

            if(m.year >= input && m.year < (input+10)){
                yearSeach.add(m.title);
            }
        }
        if (yearSeach.size()>0){
            for (String s : yearSeach){
                ui.displayMessage(s);
            }
            movieSearch();
        } else{
            ui.displayMessage("Sorry, we have no movies from this decade");
            searchByYear();
        }
    }
}