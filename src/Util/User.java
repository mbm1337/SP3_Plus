package Util;
import Util.TextUI;

import java.util.ArrayList;

public class User {
    int id;
    String name;
    String password;

    TextUI ui = new TextUI();

    public ArrayList<String> watchedList = new ArrayList<>();

    public ArrayList<String> savedList = new ArrayList<>();


    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String username, String password, int id){
        this.name = username;
        this.password = password;
        this.id = id;


    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void watchedList() {
        for (String s : watchedList) {
            ui.displayMessage(s);
        }
    }

    public void savedList() {
        for (String s : savedList) {
            ui.displayMessage(s);
        }
    }


    public ArrayList<String> getWatchedList() {
        return watchedList;
    }

    public ArrayList<String> getSavedList() {
        return savedList;
    }


}