import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Testing";
    static final String USER = "root";
    static final String PASS = "root";
    
    public static void main(String[] args) throws Exception {
       
        Connection conn = null;
        Statement stmt = null;

        
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);   

            if(conn!= null)
            {
                System.out.println("Connected to the database");
                conn.setAutoCommit(false);

                stmt = conn.createStatement();
                
                //CREATE
                String createUserSQL = "INSERT INTO NewRecords (Id,Username, Password) VALUES (2,'Saranya', 'saranya@123')";
                int rowsInserted = stmt.executeUpdate(createUserSQL);
                System.out.println(rowsInserted + "row(s) inserted.");
                
                //READ
                String readUserSQL = "SELECT * FROM NewRecords WHERE Username='Sharon'";
                ResultSet rs = stmt.executeQuery(readUserSQL);
                while(rs.next())
                {
                    int id = rs.getInt("id");
                    String Username = rs.getString("Username");
                    String Password = rs.getString("Password");
                    System.out.println("id: "+id+", Username: "+Username+", Password: "+Password);

                }
                /*UPDATE
                String updateUserSQL = "UPDATE NewRecords SET Password='sharon123' WHERE id=1";
                int rowsUpdated = stmt.executeUpdate(updateUserSQL);
                System.out.println(rowsUpdated + "row(s) updated.");

                 DELETE
                 String deleteUserSQL = "DELETE FROM NewRecords WHERE id=2";
                 int rowsDelete = stmt.executeUpdate(deleteUserSQL);
                 System.out.println(rowsDelete + "row(s) deleted.");*/
                rs.close();
                conn.setAutoCommit(true);
            
        }
    }
}