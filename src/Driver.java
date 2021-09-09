import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Driver {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/restaurantdb";
        String uname = "root";
        String password = "StrawberryCyclist";

        try {
            Connection connection = DriverManager.getConnection(url, uname, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Employee");

            while (resultSet.next()){
                System.out.println(resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }










    }













}
