package Util;
    import java.sql.*;
    import java.util.ArrayList;
    import Content.Movies;
    import Content.Series;

    public class DBConnector {


        // database URL
        static final String DB_URL = "jdbc:mysql://localhost/streaming";

        //  Database credentials
        static final String USER = "root";
        static final String PASS = "mikkelsen96";



        public ArrayList<User> readUserData() {

            ArrayList<User> users = new ArrayList<>();

            Connection conn = null;
            PreparedStatement stmt = null;
            try{
                //STEP 1: Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                //STEP 2: Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                //STEP 3: Execute a query
                System.out.println("Creating statement...");
                String sql = "SELECT ID, Username, Password FROM streaming.user";
                stmt = conn.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery(sql);

                //STEP 4: Extract data from result set
                while(rs.next()){
                    //Retrieve by column name

                    int id = rs.getInt("ID");
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");

                    User user = new User(username,password,id);

                    users.add(user);

                }


                //STEP 5: Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        stmt.close();
                }catch(SQLException se2){
                }// nothing we can do
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try

            return users;
        }

        public ArrayList<Series> readSeriesData() {

            ArrayList<Series> series = new ArrayList<>();

            Connection conn = null;
            PreparedStatement stmt = null;
            try{
                //STEP 1: Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                //STEP 2: Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                //STEP 3: Execute a query
                System.out.println("Creating statement...");
                String sql = "SELECT ID, title, year, genre, rating, episodes  FROM streaming.series";
                stmt = conn.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery(sql);

                //STEP 4: Extract data from result set


                while(rs.next()){
                    //Retrieve by column name

                    int id = rs.getInt("ID");
                    String title = rs.getString("title");
                    String year = rs.getString("year");
                    String genre = rs.getString("genre");
                    float rating = rs.getFloat("rating");
                    String episodes = rs.getString("episodes");

                    Series serie = new Series(id,title,year,genre,rating,episodes);
                    series.add(serie);
                }


                //STEP 5: Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        stmt.close();
                }catch(SQLException se2){
                }// nothing we can do
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try

            return series;
        }

        public ArrayList<Movies> readMovieData() {

            ArrayList<Movies> movies = new ArrayList<>();

            Connection conn = null;
            PreparedStatement stmt = null;
            try{
                //STEP 1: Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                //STEP 2: Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                //STEP 3: Execute a query
                System.out.println("Creating statement...");
                String sql = "SELECT ID, title, year, genre, rating FROM streaming.movies";
                stmt = conn.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery(sql);

                //STEP 4: Extract data from result set


                while(rs.next()){
                    //Retrieve by column name

                    int id = rs.getInt("ID");
                    String title = rs.getString("title");
                    int year = rs.getInt("year");
                    String genre = rs.getString("genre");
                    float rating = rs.getFloat("rating");

                    Movies movie = new Movies(id,title,year,genre,rating);
                    movies.add(movie);



                }


                //STEP 5: Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        stmt.close();
                }catch(SQLException se2){
                }// nothing we can do
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try

            return movies;
        }


    }
