import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Scanner;

public class Employee_payroll {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement stmt = null;
        String query = "select * form payroll_services.employee_payroll where name = ? ";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Name to fetch Employee Payroll details");
        String name = sc.next();
        sc.close();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Siddharth@1309");
            System.out.println("Connection establish");
            stmt = connection.prepareStatement(query);
            System.out.println("Platform Created");
            stmt.setString(1, name);
            ResultSet resultSet = stmt.executeQuery();
            System.out.println("Data Fetched from DB");
            if(resultSet.next()){
                System.out.println("ID ="+ resultSet.getString("id"));
                System.out.println("name = "+resultSet.getString("name"));
                System.out.println("Salary =" + resultSet.getString("salary"));
                System.out.println("Start ="+ resultSet.getString("start"));
            }else{
                System.out.println("Data Not Found" + name);
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
