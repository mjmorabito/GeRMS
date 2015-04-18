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
