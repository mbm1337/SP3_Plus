package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class UserHandler {
    private ArrayList<User> users = new ArrayList<>();
    private File file;
    private Scanner scanner;
    private FileWriter filewriter;


    public UserHandler(String path) throws IOException {
        try {
            file = new File(path);
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String input = scanner.nextLine();
                String[] values = input.split(",");
                users.add(new User(values[0], values[1]));
            }
            filewriter = new FileWriter(file);

        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("File you trying to write in not found");
        }

    }


    public boolean createUser(String username, String password) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return false;
            }
        }
        users.add(new User(username, password));
        return true;
    }


    public ArrayList<User> loadUsers(){
        while(scanner.hasNextLine()){
            String input = scanner.nextLine();
            String[] values = input.split(",");
            users.add(new User(values[0], values[1]));
        }
        return users;
    }

    public void saveUsers() {
        try{

            for(User user:users){
                filewriter.write(user.getName() + "," + user.getPassword()+"\n");
            }
            filewriter.close();
        }
        catch (IOException e){
            System.out.println("Sorry, the system is not working currently");
        }
    }
}