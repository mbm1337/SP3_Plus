package Util;
import Util.TextUI;

import java.util.ArrayList;

public class User {
    private String name;

    private String password;

    private int id;

    private TextUI ui = new TextUI();

    public ArrayList<String> watchedMovieList = new ArrayList<>();

    public ArrayList<String> savedMovieList = new ArrayList<>();
    public ArrayList<String> watchedSeriesList = new ArrayList<>();

    public ArrayList<String> savedSeriesList = new ArrayList<>();


    public User(String username, String password, int id){
        this.name = username;
        this.password = password;
        this.id = id;
    }
    public User(String name, String password) {
        this.name = name;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void displayList(ArrayList<String> list) {
        for (String s : list) {
            ui.displayMessage(s);
        }
    }
    public ArrayList<String> getWatchedMovieList() {
        return watchedMovieList;
    }

    public ArrayList<String> getSavedMovieList() {
        return savedMovieList;
    }

    public ArrayList<String> getWatchedSeriesList() {
        return watchedSeriesList;
    }

    public ArrayList<String> getSavedSeriesList() {
        return savedSeriesList;
    }
    @Override
    public String toString() {
        return  name;
    }

}