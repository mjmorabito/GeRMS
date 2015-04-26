import java.sql.*;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author searomg
 */
public class dbClass {
    
    private static final String dbClassName = "com.mysql.jdbc.Driver";
    private static final String CONNECTION = "jdbc:mysql://localhost/germs";   
    
    public dbClass(){
        
    }
    
    public int[] allpracticescompletedPREKK(String user){
        int[] completedpractices = new int[8];
        
        for(int i = 0;i<completedpractices.length; i++){
            completedpractices[i] = 0;
        }
        
        
        // A try/catch block to get information from the database using SQL
        try {
                // Database Driver
                Class.forName(dbClassName);

                // user/pwd to connect to DB
                Properties p = new Properties();
                p.put("user","GermsAdmin");
                p.put("password","g3rm5p0w3ru53r");

                // DB connection
                Connection conn = DriverManager.getConnection(CONNECTION,p);
                Statement stmt = conn.createStatement();
                
                String sql = "SELECT * FROM practices WHERE PaccUser = '" + user + "'";
                ResultSet rs = stmt.executeQuery(sql);
                
                // Loops through all the elements in the ResultSet
                while(rs.next()){
                    String id = rs.getString("PstandardID");
                    
                    //if standard is already completed, tag array location as 1
                    switch(id){
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
        }
        catch (Exception e){}
        
        
        return completedpractices;
    }
    
    public void completepractice(String user, String kn){
        
        // A try/catch block to get information from the database using SQL
            try {
                // Database Driver
                Class.forName(dbClassName);

                // user/pwd to connect to DB
                Properties p = new Properties();
                p.put("user","GermsAdmin");
                p.put("password","g3rm5p0w3ru53r");

                // DB connection
                Connection conn = DriverManager.getConnection(CONNECTION,p);
                Statement stmt = conn.createStatement();
                
                String sql = "SELECT * FROM practices WHERE PaccUser = '" + user + "' AND "
                        + "PstandardID = '" + kn + "'";
                ResultSet rs = stmt.executeQuery(sql);
                // Loops through all the elements in the ResultSet
                
                if (rs.next() == false){
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
