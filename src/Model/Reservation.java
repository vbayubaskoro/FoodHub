package Model;

import java.util.Date;

public class Reservation {
    private int CustomerID;
    private int TableID;
    private String ReservationDay;


    public Reservation(int CustomerID, int TableID, String ReservationDay) {
        this.CustomerID = CustomerID;
        this.TableID = TableID;
        this.ReservationDay = ReservationDay;


    }

    public int getCustomerID() {
        return CustomerID;
    }

    public int getTableID() {
        return TableID;
    }

    public String getReservation() {
        return ReservationDay;
    }
}
