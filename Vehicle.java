import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;


public class Vehicle{

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Student";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) throws Exception{
        Connection conn = null;
        Statement stmt = null;

        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        if(conn!=null)
        {
            System.out.println("Connected");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            String Csql = "INSERT INTO Vehicle (Id, Name, Colour) VALUES (1,'Toyota','Red')";
            int ri = stmt.executeUpdate(Csql);
            System.out.println(ri);

            String Rsql = "SELECT * FROM Vehicle WHERE id=1";
            ResultSet rs = stmt.executeQuery(Rsql);
            while(rs.next()){
                int id = rs.getInt("id");
                String Name = rs.getString("Name");
                String Colour = rs.getString("Colour");
                System.out.println("id: "+id+" name: "+Name + " colour: " + Colour);
            }

            String Usql = " UPDATE Vehicle SET Name='Porche' WHERE id=1";
            int roi = stmt.executeUpdate(Usql);
            System.out.println(roi);


            String Dsql = "DELETE FROM Vehicle WHERE id=1";
            int rowi = stmt.executeUpdate(Dsql);
            System.out.println(rowi);

            rs.close();
            conn.setAutoCommit(true);
        }
        
    }
}
