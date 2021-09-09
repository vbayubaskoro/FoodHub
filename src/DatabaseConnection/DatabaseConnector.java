package DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.EmployeeAtRestaurant;

public class DatabaseConnector {
    private static String url = "jdbc:mysql://localhost:3306/restaurantdb";
    private static String uname = "root";
    private static String password = "";
    private static Connection connection;

        public static void main(String[] args){
        }



    public static void insertEmployee(int ID, String Name, String Role, int restaurantID, int Salary, int Hours ) {
            try {
                openConnection();
                Statement statement = connection.createStatement();
                String sql = String.format("INSERT into EmployeeAtRestaurant Values('%s', '%s', '%s', '%s', '%s', '%s')", ID, Name, Role, restaurantID, Salary, Hours);
                statement.executeUpdate(sql);
                connection.close();
                } catch (Exception e) {
                    System.out.print("could not execute statement");
                    e.printStackTrace();
                }
        }

        public static void deleteEmployee(int ID) {
            try {
                openConnection();
                Statement statement = connection.createStatement();
                String sql = String.format("DELETE from EmployeeAtRestaurant WHERE EmployeeID = '%s'", ID);
                statement.executeUpdate(sql);
                connection.close();
                } catch (Exception e) {
                    System.out.print("could not execute statement");
                    e.printStackTrace();
                }
        }


    public static void updateEmployee(int newID, String newName, String newRole,int newRestaurantID, int newSalary, int newHours, int oldID) {
        try {
            openConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("UPDATE EmployeeAtRestaurant SET EmployeeID = '%s', EmployeeName = '%s', EmployeeRole='%s', RestaurantID = '%s', EmployeeSalary= '%s', EmployeeHours='%s' WHERE EmployeeID = '%s'", newID, newName, newRole,newRestaurantID, newSalary, newHours, oldID);
            statement.executeUpdate(sql);
            connection.close();
        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
        }
    }

    public static void deleteRestaurant(int ID) {
        try {
            openConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("DELETE FROM Restaurant WHERE RestaurantID = '%s'", ID);
            statement.executeUpdate(sql);
            connection.close();
        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getColumn(String column, int restaurantID) {
        try {
            ArrayList<String> emp_attr = new ArrayList<>();
            String sql = String.format("Select %s from EmployeeAtRestaurant WHERE RestaurantID = '%s'", column, restaurantID);
            openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                emp_attr.add(resultSet.getString(column));
            }
            connection.close();
            return emp_attr;
        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<String> getColumn(String column, String filter_column, String filter_val, int restaurantID) {
        try {
            ArrayList<String> emp_attr = new ArrayList<>();
            String sql = String.format("Select %s from EmployeeAtRestaurant WHERE %s = '%s' AND RestaurantID = '%s'", column, filter_column, filter_val, restaurantID);
            openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                emp_attr.add(resultSet.getString(column));
            }
            connection.close();
            return emp_attr;
        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<String> getColumn(String column, String filter_column1, String filter_val1, String filter_column2, String filter_val2, int restaurantID) {
        try {
            ArrayList<String> emp_attr = new ArrayList<>();
            String sql = String.format("Select %s from EmployeeAtRestaurant WHERE %s = '%s' AND %s = '%s' AND RestaurantID = '%s'", column, filter_column1, filter_val1, filter_column2, filter_val2, restaurantID);
            openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                emp_attr.add(resultSet.getString(column));
            }
            connection.close();
            return emp_attr;
        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
            return null;
        }
    }


    public static int getRestaurantID(String restaurantName) {
        try {
            openConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select * from Restaurant WHERE RestaurantName = '%s'", restaurantName);
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                int retval = -1;
                connection.close();
                return retval;
            } else {
                int retval = resultSet.getInt("RestaurantID");
                connection.close();
                return retval;
            }
        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean isValidID(int ID) {
        try {
            openConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select * from Customer2 WHERE CustomerID = '%s'", ID);
            ResultSet resultSet = statement.executeQuery(sql);
            boolean retval = (resultSet.next());
            connection.close();
            return retval;
        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
            return false;
    }

    }


    public static Object[][] getMinMaxAvgHours(String option, int restaurantID, String role){
            try {
                openConnection();
                ArrayList<String> list1;
                ArrayList<String> list2;
                ArrayList<String> list3;
                int answer = 0;
                String name = "";
                int employeeID = 0;
                Object[][] retObj = null;
                if (option == "Max") {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet;
                    if (role.equals("") || role.equals("ALL")) {
                        resultSet = statement.executeQuery(String.format("select max(EmployeeHours) AS MaxHour from EmployeeAtRestaurant WHERE RestaurantID = '%s'", restaurantID));
                        while (resultSet.next()){
                            answer = resultSet.getInt(("MaxHour"));
                        }
                        list1 = getColumn("EmployeeID", "EmployeeHours", Integer.toString(answer), restaurantID);
                        list2 = getColumn("EmployeeName", "EmployeeHours", Integer.toString(answer), restaurantID);
                        list3 = getColumn("EmployeeHours", "EmployeeHours", Integer.toString(answer), restaurantID);
                    } else {
                        resultSet = statement.executeQuery(String.format("select max(EmployeeHours) AS MaxHour from EmployeeAtRestaurant WHERE RestaurantID = '%s' AND EmployeeRole = '%s'", restaurantID, role));
                        while (resultSet.next()){
                            answer = resultSet.getInt(("MaxHour"));
                        }
                        list1 = getColumn("EmployeeID", "EmployeeHours", Integer.toString(answer), "EmployeeRole", role, restaurantID);
                        list2 = getColumn("EmployeeName", "EmployeeHours", Integer.toString(answer), "EmployeeRole", role, restaurantID);
                        list3 = getColumn("EmployeeHours", "EmployeeHours", Integer.toString(answer), "EmployeeRole", role, restaurantID);
                    }

                    retObj = new Object[list1.size()][3];
                    for (int i = 0; i < list1.size(); i++) {
                        retObj[i][0] = list1.get(i);
                        retObj[i][1] = list2.get(i);
                        retObj[i][2] = list3.get(i);
                    }
                }
                if (option == "Min") {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet;
                    if (role.equals("") || role.equals("ALL")) {
                        resultSet = statement.executeQuery(String.format("select min(EmployeeHours) AS MinHour from EmployeeAtRestaurant WHERE RestaurantID = '%s'", restaurantID));
                        while (resultSet.next()){
                            answer = resultSet.getInt(("MinHour"));
                        }
                        list1 = getColumn("EmployeeID", "EmployeeHours", Integer.toString(answer), restaurantID);
                        list2 = getColumn("EmployeeName", "EmployeeHours", Integer.toString(answer),  restaurantID);
                        list3 = getColumn("EmployeeHours", "EmployeeHours", Integer.toString(answer), restaurantID);
                    } else {
                        resultSet = statement.executeQuery(String.format("select min(EmployeeHours) AS MinHour from EmployeeAtRestaurant WHERE RestaurantID = '%s' AND EmployeeRole = '%s'", restaurantID, role));
                        while (resultSet.next()){
                            answer = resultSet.getInt(("MinHour"));
                        }
                        list1 = getColumn("EmployeeID", "EmployeeHours", Integer.toString(answer), "EmployeeRole", role, restaurantID);
                        list2 = getColumn("EmployeeName", "EmployeeHours", Integer.toString(answer), "EmployeeRole", role, restaurantID);
                        list3 = getColumn("EmployeeHours", "EmployeeHours", Integer.toString(answer), "EmployeeRole", role, restaurantID);
                    }
                    retObj = new Object[list1.size()][3];
                    for (int i = 0; i < list1.size(); i++) {
                        retObj[i][0] = list1.get(i);
                        retObj[i][1] = list2.get(i);
                        retObj[i][2] = list3.get(i);
                    }
                }
                if (option == "Avg") {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet;
                   if (role.equals("") || role.equals("ALL")) {
                       resultSet = statement.executeQuery(String.format("select avg(EmployeeHours) AS AvgHour from EmployeeAtRestaurant WHERE RestaurantID = '%s'", restaurantID));
                   } else {
                       resultSet = statement.executeQuery(String.format("select avg(EmployeeHours) AS AvgHour from EmployeeAtRestaurant WHERE RestaurantID = '%s' AND EmployeeRole = '%s'", restaurantID, role));
                   }
                    while (resultSet.next()){
                        answer = resultSet.getInt(("AvgHour"));
                    }
                    retObj = new Object[1][1];
                    retObj[0][0] = answer;
                }
                connection.close();
                return retObj;

            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }

    }



    public static Object[][] addReservation(int CustomerID, int TableID, String ReservationDay ) {
        try {
            openConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("INSERT into Reservation Values('%s', '%s', '%s')", CustomerID, TableID, ReservationDay);
            statement.executeUpdate(sql);
            connection.close();
            return getReservations(CustomerID);
        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
            return null;
        }
    }

    public static int getTableSeatsInfo(int TableID) {
        try {
            openConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("select NumberOfSeats, Reservation.TableID from Reservation, TableAtRestaurant WHERE Reservation.TableID = TableAtRestaurant.TableID and Reservation.TableID = %s", TableID);
            ResultSet resultSet = statement.executeQuery(sql);
            int seats = 0;
            while (resultSet.next()){
                seats = resultSet.getInt(("NumberOfSeats"));
            }
            connection.close();
            return seats;
        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
            return 0;
        }
    }

    public static int getNumSeats(int TableID) {
        try {
            openConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select * from TableAtRestaurant WHERE TableID = '%s'", TableID);
            ResultSet resultSet = statement.executeQuery(sql);
            int seats = 0;
            while (resultSet.next()){
                seats = resultSet.getInt(("NumberOfSeats"));
            }
            connection.close();
            return seats;
        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
            return 0;
        }

    }

    public static boolean reservationAvailable(int tableID, String reservationDay) {
        try {
            openConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select * from Reservation WHERE TableID = '%s' AND ReservationDay = '%s'", tableID, reservationDay);
            ResultSet resultSet = statement.executeQuery(sql);
            boolean retval = !resultSet.next();
            connection.close();
            return retval;
        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
            return false;
        }

    }

    public static boolean reservationAvailable(int tableID, int customerID) {
        try {
            openConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select * from Reservation WHERE TableID = '%s' AND CustomerID = '%s'", tableID, customerID);
            ResultSet resultSet = statement.executeQuery(sql);
            boolean retval = !resultSet.next();
            connection.close();
            return retval;
        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
            return false;
        }

    }

    public static ArrayList<Integer> getTables(int restaurantID) {
        try {
            openConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select TableID from TableAtRestaurant WHERE RestaurantID = '%s'", restaurantID);
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Integer> tableIDs = new ArrayList<Integer>();
            while (resultSet.next()){
                tableIDs.add(resultSet.getInt(("TableID")));
            }
            connection.close();
            return tableIDs;

        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
            return null;
        }
    }

    public static Object[][] getReservations(int customerID) {
        try {
            openConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("select NumberOfSeats, Reservation.TableID, RestaurantName, ReservationDay FROM Reservation, TableAtRestaurant, Restaurant WHERE Reservation.TableID = TableAtRestaurant.TableID AND TableAtRestaurant.RestaurantID = Restaurant.RestaurantID AND Reservation.CustomerID = '%s'", customerID);
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Integer> tableIDs = new ArrayList<>();
            ArrayList<Integer> numSeats = new ArrayList<>();
            ArrayList<String> restName = new ArrayList<>();
            ArrayList<String> date = new ArrayList<>();
            while (resultSet.next()){
                tableIDs.add(resultSet.getInt(("TableID")));
                numSeats.add(resultSet.getInt("NumberOfSeats"));
                restName.add(resultSet.getString("RestaurantName"));
                date.add(resultSet.getString("ReservationDay"));
            }
            Object[][] retObj = new Object[tableIDs.size()][4];
            for (int i = 0; i<tableIDs.size(); i++) {
                retObj[i][0] = restName.get(i);
                retObj[i][1] = tableIDs.get(i);
                retObj[i][2] = numSeats.get(i);
                retObj[i][3] = date.get(i);
            }
            connection.close();
            return retObj;

        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
            return null;
        }

    }

    public static Object[][] getReservations(int customerID, String[] fields) {
        try {
            String cols = "";
            for (int i = 0; i < fields.length-1; i++) {
                cols = cols.concat(fields[i] + ", ");
            }
            cols = cols.concat(fields[fields.length-1]);
            openConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("SELECT %s FROM Reservation, TableAtRestaurant, Restaurant WHERE Reservation.TableID = TableAtRestaurant.TableID AND TableAtRestaurant.RestaurantID = Restaurant.RestaurantID AND Reservation.CustomerID = '%s'", cols, customerID);
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Integer> tableIDs = null;
            ArrayList<Integer> numSeats = null;
            ArrayList<String> restName = null;
            ArrayList<String> date = null;
            boolean[] selected_cols = {false, false, false, false};
            int num_selected = 0;

            for (String field : fields) {
                num_selected++;
                switch(field) {
                    case "RestaurantName":
                        restName = new ArrayList<>();
                        selected_cols[0] = true;
                        break;
                    case "Reservation.TableID":
                        tableIDs = new ArrayList<>();
                        selected_cols[1] = true;
                        break;
                    case "NumberOfSeats":
                        numSeats = new ArrayList<>();
                        selected_cols[2] = true;
                        break;
                    case "ReservationDay":
                        date = new ArrayList<>();
                        selected_cols[3] = true;
                        break;
                }
            }
            int num_rows = 0;
            while (resultSet.next()){
                num_rows++;
                if (selected_cols[0]) {
                    restName.add(resultSet.getString("RestaurantName"));
                }
                if (selected_cols[1]) {
                    tableIDs.add(resultSet.getInt("Reservation.TableID"));
                }
                if (selected_cols[2]) {
                    numSeats.add(resultSet.getInt("NumberOfSeats"));
                }
                if (selected_cols[3]) {
                    date.add(resultSet.getString("ReservationDay"));
                }
            }
            Object[][] retObj = new Object[num_rows][num_selected];
            for (int i = 0; i<num_rows; i++) {
                int k = 0;
                    if (selected_cols[0]) {
                        retObj[i][k] = restName.get(i);
                        k++;
                    }
                    if (selected_cols[1]) {
                        retObj[i][k] = tableIDs.get(i);
                        k++;
                    }
                    if (selected_cols[2]) {
                        retObj[i][k] = numSeats.get(i);
                        k++;
                    }
                    if (selected_cols[3]) {
                        retObj[i][k] = date.get(i);
                        k++;
                    }
            }
            connection.close();
            return retObj;

        } catch (Exception e) {
            System.out.print("could not execute statement");
            e.printStackTrace();
            return null;
        }

    }

    public static int nestedAgg(String role, String func, int restaurantID) {
            try {
                String applied_func;
                switch (func) {
                    case "Max":
                        applied_func = "MAX(EmployeeSalary)";
                        break;
                    case "Min":
                        applied_func = "MIN(EmployeeSalary)";
                        break;
                    default:
                        applied_func = "AVG(EmployeeSalary)";
                }
                openConnection();
                Statement statement = connection.createStatement();
                String sql = String.format("SELECT COUNT(*) AS Num FROM EmployeeAtRestaurant WHERE RestaurantID = '%s' AND EmployeeRole = '%s' AND EmployeeSalary >= ALL (SELECT %s FROM EmployeeAtRestaurant WHERE RestaurantID = '%s' GROUP BY EmployeeRole)", restaurantID, role, applied_func, restaurantID);
                ResultSet resultSet = statement.executeQuery(sql);
                int i = 0;
                while(resultSet.next()) {
                    i = resultSet.getInt("Num");
                }
                return i;

            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }

    }

    public static ArrayList<String> getPerfCustomer(String restaurantName) {
            try {
                ArrayList<String> retArr = new ArrayList<>();
                openConnection();
                Statement statement = connection.createStatement();
                String sql = String.format("SELECT * FROM Customer2 WHERE NOT EXISTS (SELECT * from TableAtRestaurant, Restaurant WHERE RestaurantName = '%s' AND Restaurant.RestaurantID = TableAtRestaurant.RestaurantID AND NOT EXISTS (SELECT CustomerID FROM Reservation WHERE Customer2.CustomerID = Reservation.CustomerID AND TableAtRestaurant.TableID = Reservation.TableID))", restaurantName);
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    retArr.add(resultSet.getString("Cu2_Name"));
                }
                return retArr;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
    }

    public static boolean restaurantExists(String restaurantName) {
        try {
            openConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("SELECT * FROM Restaurant WHERE RestaurantName = '%s'", restaurantName);
            ResultSet resultSet = statement.executeQuery(sql);
            boolean retval = resultSet.next();
            connection.close();
            return retval;
            } catch(Exception e){
                e.printStackTrace();
                return false;
            }
    }

    private static void openConnection() {
            try {
                connection = DriverManager.getConnection(url, uname, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
