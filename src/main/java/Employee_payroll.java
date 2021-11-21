import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public class Employee_payroll {

    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        String query = "select * form payroll_services.employee_payroll where start between cast ('2018-01-05' as date) and date(now()) ";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Siddharth@1309");
            System.out.println("Connection establish");
            stmt = connection.createStatement();
            System.out.println("Platform Created");
            ResultSet resultSet = stmt.executeQuery(query);
            System.out.println("Data Fetched from DB");
            if(resultSet.next()){
                System.out.println("ID ="+ resultSet.getString("id"));
                System.out.println("name = "+resultSet.getString("name"));
                System.out.println("Salary =" + resultSet.getString("salary"));
                System.out.println("Start ="+ resultSet.getString("start"));
            }
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
