import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Employee_payroll {

    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        String query = "select * from payroll_services.employee_payroll where id=2";
        try {
            connection = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Siddharth@1309");
            System.out.println("Connection establish");
            stmt = connection.createStatement();
            System.out.println("Platform Created");
            stmt.executeQuery(query);
            ResultSet resultSet = stmt.getResultSet();
            if (resultSet.next()){
                System.out.println("ID = "+ resultSet.getInt("id"));
                System.out.println("Name = "+ resultSet.getString("name"));
                System.out.println("Gender = "+ resultSet.getString("gender"));
                System.out.println("Salary = "+ resultSet.getInt("salary"));
                System.out.println("Phone = "+ resultSet.getInt("phone"));
                System.out.println("Address = "+ resultSet.getString("address"));
                System.out.println("Department = "+ resultSet.getString("department"));
            }
            System.out.println("Data Inserted");
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
