package Model;

public class Drink implements Dish{
    private boolean hasAlcohol;
    private boolean isHot;

    public Drink(boolean alcoholic, boolean hot) {
        this.hasAlcohol = alcoholic;
        this.isHot = hot;
    }

    public boolean getisStatic() {
        return this.hasAlcohol;
    }

    public boolean getIsHot() {
        return this.isHot;
    }
}
