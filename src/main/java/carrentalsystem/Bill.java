package carrentalsystem;

import lombok.Getter;

import java.util.Date;

@Getter
public class Bill {
    private double amountToPay;
    private Date date;

    public Bill(double amountToPay, Date date) {
        this.amountToPay = amountToPay;
        this.date = date;
    }

    public boolean payBill() {
        return true;
    }
}
