package vendingmachine.dao;

import lombok.Getter;
import lombok.ToString;
import vendingmachine.exceptions.InsufficientAmountException;

@Getter
@ToString
public class Currency {
    private static Currency INSTANCE;
    private int machineAmount;


    public static Currency getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Currency();
        }
        return INSTANCE;
    }


    private Currency() {
        this.machineAmount = 0;
    }

    public int returnChange(int amount, int paid) throws InsufficientAmountException {
        if (amount > paid) throw new InsufficientAmountException(paid + " amount is not enough, need " + amount + "!");
        machineAmount += paid;
        return paid - amount;
    }

    public int addCurrency(int amount) {
        machineAmount += amount;
        return machineAmount;
    }
}
