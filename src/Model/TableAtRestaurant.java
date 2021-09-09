package Model;

public class TableAtRestaurant {
    private int TableID;
    private int NumberOfSeats;
    private boolean InsideOrOutside;
    private int RestaurantID;

    public TableAtRestaurant(int TableID, int NumberOfSeats, boolean InsideOrOutside, int RestaurantID) {
        this.TableID = TableID;
        this.NumberOfSeats = NumberOfSeats;
        this.InsideOrOutside = InsideOrOutside;
        this.RestaurantID = RestaurantID;



    }

    public int getTableID() {
        return TableID;
    }

    public int getNumberOfSeats() {
        return NumberOfSeats;
    }

    public boolean getInsideOrOutside() {
        return InsideOrOutside;
    }

    public int getRestaurantID() {
        return RestaurantID;
    }
}
