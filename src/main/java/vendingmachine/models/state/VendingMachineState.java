package vendingmachine.models.state;

import vendingmachine.models.Item;
import vendingmachine.models.scanner.MoneyScanner;

public interface VendingMachineState {
    public void collectCash(int paidAmount, MoneyScanner moneyScanner) throws Exception;

    public int dispenseChange() throws Exception;

    public Item dispenseItem(int productId, int count) throws Exception;

    public int cancelTransaction() throws Exception;
}
