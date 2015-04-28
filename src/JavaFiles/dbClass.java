/*
 * Team name: GeRMS
 * Team members: Gustavo Moraes, Ryan Ahearn, Mark Morabito, and Samir Leal
 * Date: 04/30/15
 * Purpose: In this project, you and your partners will work to write a program to 
 * create a Math Tutor Software System to help elementary school students.
 *
 * This software will help elementary school students to study and practice math skills.
 *
 * The math curriculum information in Massachusetts is in following link: 
 * http://www.doe.mass.edu/frameworks/math/2000/toc.html
 *
 * The client requests following features as minimum:
 *     practice test materials
 *     tutorials
 *     printing the record(test results)
 *     different level tests for each grade
 *     security(log-in, log-out)
 *     Reward
 *
 */
import java.sql.*;
import java.util.Properties;
import javax.swing.JOptionPane;
/*
 * This is the class for the database.
 * We connect to the mySQL database and manage the user level of completion on
 * practice, quizzes and finals.
 */

public class dbClass {

    private static final String dbClassName = "com.mysql.jdbc.Driver";
    private static final String CONNECTION = "jdbc:mysql://localhost/germs";

    public dbClass() {

    }

    //This method checks to see if the user has completed the hard quiz, which allows them
    //to take the final test.
    public boolean completedhardquiz(String user, int grade) {

        boolean completed = false;
        // A try/catch block to get information from the database using SQL
        try {
            // Database Driver
            Class.forName(dbClassName);

            // user/pwd to connect to DB
            Properties p = new Properties();
            p.put("user", "GermsAdmin");
            p.put("password", "g3rm5p0w3ru53r");

            // DB connection
            Connection conn = DriverManager.getConnection(CONNECTION, p);
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM quizzes WHERE QaccUser = '" + user + "'"
                    + "AND QgradeID=" + grade + " AND Qdifficulty=3 AND Qcorrectanswers>=4";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                completed = true;
            }
        } catch (Exception e) {
        }

        return completed;
    }

    //This method checks for practice completion in grades 3 and 4
    public int[] allpracticescompleted34(String user) {
        int[] completedpractices = new int[]{0};

        // A try/catch block to get information from the database using SQL
        try {
            // Database Driver
            Class.forName(dbClassName);

            // user/pwd to connect to DB
            Properties p = new Properties();
            p.put("user", "GermsAdmin");
            p.put("password", "g3rm5p0w3ru53r");

            // DB connection
            Connection conn = DriverManager.getConnection(CONNECTION, p);
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM practices WHERE PaccUser = '" + user + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Loops through all the elements in the ResultSet
            while (rs.next()) {
                String id = rs.getString("PstandardID");

                //If standard is already completed, tag array location as 1
                switch (id) {
                    case "4N12":
                        completedpractices[0] = 1;
                        break;
                }
            }
        } catch (Exception e) {
        }

        return completedpractices;
    }

    // This method chceks to see that all practice tests in grades 1 and 2 are completed 
    // so that the user can take the final test
    public int[] allpracticescompleted12(String user) {
        int[] completedpractices = new int[]{0};

        // A try/catch block to get information from the database using SQL
        try {
            // Database Driver
            Class.forName(dbClassName);

            // user/pwd to connect to DB
            Properties p = new Properties();
            p.put("user", "GermsAdmin");
            p.put("password", "g3rm5p0w3ru53r");

            // DB connection
            Connection conn = DriverManager.getConnection(CONNECTION, p);
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM practices WHERE PaccUser = '" + user + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Loops through all the elements in the ResultSet
            while (rs.next()) {
                String id = rs.getString("PstandardID");

                //if standard is already completed, tag array location as 1
                switch (id) {
                    case "2N4":
                        completedpractices[0] = 1;
                        break;
                }
            }
        } catch (Exception e) {
        }

        return completedpractices;
    }

    public int[] allpracticescompletedPREKK(String user) {
        int[] completedpractices = new int[8];

        for (int i = 0; i < completedpractices.length; i++) {
            completedpractices[i] = 0;
        }

        // A try/catch block to get information from the database using SQL
        try {
            // Database Driver
            Class.forName(dbClassName);

            // user/pwd to connect to DB
            Properties p = new Properties();
            p.put("user", "GermsAdmin");
            p.put("password", "g3rm5p0w3ru53r");

            // DB connection
            Connection conn = DriverManager.getConnection(CONNECTION, p);
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM practices WHERE PaccUser = '" + user + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Loops through all the elements in the ResultSet
            while (rs.next()) {
                String id = rs.getString("PstandardID");

                //If standard is already completed, tag array location as 1
                switch (id) {
                    case "KN1":
                        completedpractices[0] = 1;
                        break;
                    case "KN2":
                        completedpractices[1] = 1;
                        break;
                    case "KN3":
                        completedpractices[2] = 1;
                        break;
                    case "KN4":
                        completedpractices[3] = 1;
                        break;
                    case "KN5":
                        completedpractices[4] = 1;
                        break;
                    case "KN6":
                        completedpractices[5] = 1;
                        break;
                    case "KN7":
                        completedpractices[6] = 1;
                        break;
                    case "KN8":
                        completedpractices[7] = 1;
                        break;
                }
            }
        } catch (Exception e) {
        }

        return completedpractices;
    }

    public void completepractice(String user, String kn) {

        // A try/catch block to get information from the database using SQL
        try {
            // Database Driver
            Class.forName(dbClassName);

            // user/pwd to connect to DB
            Properties p = new Properties();
            p.put("user", "GermsAdmin");
            p.put("password", "g3rm5p0w3ru53r");

            // DB connection
            Connection conn = DriverManager.getConnection(CONNECTION, p);
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM practices WHERE PaccUser = '" + user + "' AND "
                    + "PstandardID = '" + kn + "'";
            ResultSet rs = stmt.executeQuery(sql);
                // Loops through all the elements in the ResultSet

            if (rs.next() == false) {
                // Inserts the data into the database
                sql = "INSERT INTO practices VALUES('" + user + "','" + kn + "');";
                stmt.executeUpdate(sql);
            }

            // Closes the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }

    }

}
