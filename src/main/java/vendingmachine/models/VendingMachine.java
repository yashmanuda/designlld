package vendingmachine.models;

import lombok.Getter;
import vendingmachine.dao.Currency;
import vendingmachine.dao.Inventory;
import vendingmachine.models.scanner.MoneyScanner;
import vendingmachine.models.state.ReadyState;
import vendingmachine.models.state.VendingMachineState;


@Getter
public class VendingMachine {
    private Inventory inventory;
    private Currency currency;
    private VendingMachineState state;
    private Integer collectedCash;
    private Integer amountToPay;

    public VendingMachine() {
        inventory = Inventory.getInstance();
        currency = Currency.getInstance();
        state = new ReadyState(this);
        collectedCash = null;
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void setCollectedCash(Integer collectedMoney) {
        this.collectedCash = collectedMoney;
    }

    public void setAmountToPay(Integer amountToPay) {
        this.amountToPay = amountToPay;
    }

    public void collectCash(int amountPaid, MoneyScanner scanner) throws Exception {
        this.state.collectCash(amountPaid, scanner);
    }

    public Item dispenseItem(int productId, int count) throws Exception {
        return this.state.dispenseItem(productId, count);
    }

    public int dispenseChange() throws Exception {
        return this.state.dispenseChange();
    }

    public int cancelTransaction() throws Exception {
        return this.state.cancelTransaction();
    }
}
