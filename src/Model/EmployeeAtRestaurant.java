package Model;

public class EmployeeAtRestaurant {
    private int ID;
    private String name;
    private String role;
    private int restaurantID;
    private int salary;
    private int hours;


    public EmployeeAtRestaurant(int ID, String name, String role, int restaurantID, int salary, int hours) {
        this.ID = ID;
        this.name = name;
        this.role = role;
        this.restaurantID = restaurantID;
        this.salary = salary;
        this.hours = hours;


    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getRole() {
        return role;
    }

    public int getRestaurantID() { return restaurantID; }

    public int getSalary() { return salary; }

    public int getHours() { return hours; }
}

