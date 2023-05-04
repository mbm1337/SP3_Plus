import Content.*;
import Util.*;
import java.util.ArrayList;

public class Streaming {
    private TextUI ui;
    private User currentUser;
    ArrayList <User> users;
    DBConnector dbc;
    private ArrayList<Movies>movies;
    private ArrayList<Series> series;
    public Streaming() {
        this.users = new ArrayList<>();
    }
    public void streamSetup() {
        ui = new TextUI();
        dbc = new DBConnector();
        users = dbc.readUserData();
        String s1 = ui.getUserInput("Already user? Y/N");
        if (s1.equalsIgnoreCase("Y")) {
            loginMenu(users);

        } else if(s1.equalsIgnoreCase("N")){
            createUserMenu(users);
        } else {
            ui.displayMessage("Not an option, please try again");
            streamSetup();
        }
    }
    public void mainMenu() {
        String input = ui.getUserInput("Please choose between; 1/2/3 \n" + "1. Movies\n" + "2. Series\n" + "3. Quit");
        switch (input){
            case "1":
               movieMenu(currentUser);
                mainMenu();
            break;
            case "2":
                seriesMenu(currentUser);
                mainMenu();
            break;
            case "3":
                ui.displayMessage("Goodbye!");
                break;
            default:
                ui.displayMessage("This is not an option");
                mainMenu();
        }
    }
    public void loginMenu(ArrayList<User> users) {

            String username = ui.getUserInput("Please enter your username:");
            String password = ui.getUserInput("Please enter your password:");
        for (User u : users) {
            String tmpUsername = u.getName();
            String tmpPassword = u.getPassword();

            if (tmpUsername.equalsIgnoreCase(username) && tmpPassword.equals(password)) {
                currentUser = u;
                ui.displayMessage("Welcome " + currentUser);
                mainMenu();
            } else {
                ui.displayMessage("Sorry, the username or password is incorrect");
                streamSetup();
            }
        }
    }
    public void createUserMenu (ArrayList<User> users) {
            String username = ui.getUserInput("Please enter a username:");
            String password = ui.getUserInput("Please enter a password:");

        for (User u : users) {
            String tmpUsername = u.getName();

            if (!tmpUsername.equalsIgnoreCase(username)) {
                User user = new User(username,password);
                users.add(user);
                currentUser = user;
                ui.displayMessage("Welcome " + currentUser);
                mainMenu();
            } else {
                ui.displayMessage("Sorry, the username is already in use");
                streamSetup();
            }
        }
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
                        "4. Review your list of watched movies\n" +
                        "5. Review your list of saved movies");
        switch (inputMovies) {
            case "1":
                movieSearch();
                break;
            case "2":
                movieGenreSearch();
                break;
            case "3":
                searchByYear();
                break;
            case "4":
                currentUser.displayList(currentUser.getWatchedMovieList());
                break;
            case "5":
                currentUser.displayList(currentUser.getSavedMovieList());
            default:
                movieMenu(currentUser);
        }
    }

    public void movieSearch() {

        String input = ui.getUserInput("Please type the desired movie:");

        for (Movies m : movies) {
            if (input.equalsIgnoreCase(m.getTitle())) {
                String input2 = ui.getUserInput("Choose between: 1/2\n" +
                        "1. Watch the chosen movie\n" +
                        "2. Save movie to your saved list");
                if (input2.equalsIgnoreCase("1")) {
                    ui.displayMessage("You are now watching " + m.getTitle());
                    currentUser.watchedMovieList.add(m.getTitle());
                    ui.displayMessage("\nThank you for watching. Do you want to watch more?");

                } else if (input2.equalsIgnoreCase("2")) {
                    currentUser.savedMovieList.add(m.getTitle());
                    ui.displayMessage("The movie was saved on your saved list.");

                } else {
                    ui.displayMessage("This is not an option");
                    movieSearch();
                }
            }
        }
    }

    public void movieGenreSearch() {
        String input = ui.getUserInput("Please type the desired genre:");

        for (Movies m : movies) {
            String [] tmpGenre = m.getGenre().split(".");

            for (String s2 : tmpGenre) {
                if (input.equalsIgnoreCase(s2.trim())) {
                    ui.displayMessage(m.getTitle());
                }
            }
        }
        movieSearch();
    }
    public void searchByYear() {
        ArrayList<String> yearSeach = new ArrayList<>();
        int input = Integer.parseInt(ui.getUserInput("Please type the desired decade:"));


        for (Movies m : movies) {

            if(m.getYear() >= input && m.getYear() < (input+10)){
                yearSeach.add(m.getTitle());
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
    public void seriesMenu(User user){
        currentUser = user;
        dbc = new DBConnector();
        series = dbc.readSeriesData();

        String inputSeries = ui.getUserInput("Please choose between following options;\n" +
                "1. Search for a specific series\n" +
                "2. Search for a genre and receive all series in this category\n" +
                "3. Review your list of watched series\n" +
                "4. Review your list of saved series");
        switch (inputSeries) {
            case "1":
                seriesSearch();
                break;
            case "2":
                seriesGenreSearch();
                break;
            case "3":
                currentUser.displayList(currentUser.getWatchedSeriesList());
                break;
            case "4":
                currentUser.displayList(currentUser.getSavedSeriesList());
                break;
            default:
                ui.displayMessage("This is not an option");
                seriesMenu(currentUser);
        }
    }
    public void seriesSearch(){
        String input = ui.getUserInput("Please type the desired series:");

        for (Series s : series) {
            if (input.equalsIgnoreCase(s.getTitle())) {
                String s2 = ui.getUserInput("Choose between: 1/2\n" +
                        "1. Watch the chosen series\n" +
                        "2. Save series to your saved list");
                if (s2.equalsIgnoreCase("1")) {
                    ui.displayMessage("You are now watching " + s.getTitle());
                    currentUser.watchedSeriesList.add(s.getTitle());
                    ui.displayMessage("\nThank you for watching. Do you want to watch more?");

                } else if(s2.equalsIgnoreCase("2")) {
                    currentUser.savedSeriesList.add(s.getTitle());
                    System.out.println("The series was saved on your watch list");
                }else {
                    ui.displayMessage("This is not an option");
                    seriesSearch();
                }
            }
        }
    }
    public void seriesGenreSearch(){
        String input = ui.getUserInput("Please type the desired genre:");

        for (Series s : series) {

            String [] tmpGenre = s.getGenre().split(".");

            for (String s2 : tmpGenre) {
                if (input.equalsIgnoreCase(s2.trim())) {
                    ui.displayMessage(s.getTitle());
                }
            }
        }
        seriesSearch();
    }
}
