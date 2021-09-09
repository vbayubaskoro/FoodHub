package Model;

public class Restaurant {
    private String ID;
    private String name;
    private String location;
    private String cuisineType;
    private Ingredient[] stockedIngredients;
    private Menu[] menus;
    private EmployeeAtRestaurant[] employees;
    private ParkingLot[] parkingLots;
    private TableAtRestaurant[] tables;

    public Restaurant(String ID) {
        this.ID = ID;
    }
}
