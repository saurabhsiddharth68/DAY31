import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Employee_payroll {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Siddharth@1309");
            System.out.println("Connection establish");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
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
