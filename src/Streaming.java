import Content.Movies;
import Content.Series;
import Util.TextUI;
import Util.User;

import Util.*;

import java.util.ArrayList;



public class Streaming {

    private TextUI ui;

    private User currentUser;
    Movies movies;
    Series series;
    UserHandler userHandler;
    ArrayList <User> users;

    DBConnector dbc;


    public Streaming() {
        this.series = new Series();
        this.movies = new Movies();
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
                movies.movieMenu(currentUser);
                mainMenu();
            break;
            case "2":
                series.seriesMenu(currentUser);
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
                mainMenu();
            } else {
                ui.displayMessage("Sorry, the username is already in use");
                streamSetup();
            }
        }


    }

}
