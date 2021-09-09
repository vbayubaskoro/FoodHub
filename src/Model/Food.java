package Model;

public class Food implements Dish {
    private String type;

    public Food(String type) {
        this.type = type;
    }

    public String geType() {
        return this.type;
    }

}
