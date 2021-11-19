import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Employee_payroll {

    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        String query = "update payroll_services.employee_payroll set salary=300000 where id=2";
        try {
            connection = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Siddharth@1309");
            System.out.println("Connection establish");
            stmt = connection.createStatement();
            System.out.println("Platform Created");
            stmt.executeUpdate(query);

            System.out.println("Update salary of Nikhil to 300000 successfully");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null){
                try{
                    stmt.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
