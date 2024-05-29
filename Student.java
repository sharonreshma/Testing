
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
public class Student {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/student";
    static final String DB_USER = "root";
    static final String DB_PASS = "root";
public static void main(String[] args) throws Exception {
    
    Connection conn = null;
    Statement stmt = null;
    
Class.forName(JDBC_DRIVER);
    conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

    if(conn!=null)
    {
System.out.println("connected");
conn.setAutoCommit(false);
stmt = conn.createStatement();
String Csql = "INSERT INTO NewRec (Id, Name, Dept) VALUES (1, 'Sharon', 'IT')";
int ri = stmt.executeUpdate(Csql);
System.out.println(ri);
String Rsql = "SELECT * FROM NewRec where id=1";
ResultSet rs=stmt.executeQuery(Rsql);
while (rs.next()) {
    int id = rs.getInt("id");
    String Name = rs.getString("Name");
    String Dept = rs.getString("Dept");
    System.out.println("id: "+id+" Name: "+Name+" Dept: "+Dept);
    
}
rs.close();
conn.setAutoCommit(true);
    }
    
}
}
