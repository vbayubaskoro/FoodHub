package Model;

public class Menu {
    private String type;
    private int numberOfItems;
    private String ID;
    private Dish[] Dishes;

    public Menu(String type, int numberOfItems, String ID) {
        this.type = type;
        this.numberOfItems = numberOfItems;
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public String getID() {
        return ID;
    }
}
