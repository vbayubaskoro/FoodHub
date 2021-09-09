package Model;

public class CustomerHasMembership {
    private int RestaurantID;
    private int CustomerID;
    private String MembershipTier;




    public int getRestaurantID() { return RestaurantID; }
    public int getCustomerID() {
        return CustomerID;
    }

    public String getMembershipTier() {
        return MembershipTier;
    }
}
