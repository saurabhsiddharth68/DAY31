import java.sql.*;

public class Employee_payroll {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement stmt = null;
        String query = "update payroll_services.employee_payroll set salary=300000 where id=3";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Siddharth@1309");
            System.out.println("Connection establish");
            stmt = connection.prepareStatement(query);
            System.out.println("Platform Created");
            stmt.executeUpdate(query);

            System.out.println("Update salary of Aryan to 300000 successfully");
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
