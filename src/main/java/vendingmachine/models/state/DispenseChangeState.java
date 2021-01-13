package vendingmachine.models.state;

import vendingmachine.models.Item;
import vendingmachine.models.VendingMachine;
import vendingmachine.models.scanner.MoneyScanner;

public class DispenseChangeState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public DispenseChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int paidAmount, MoneyScanner moneyScanner) {
        throw new RuntimeException("Dispensing cash cannot collect more cash!");
    }

    @Override
    public int dispenseChange() throws Exception {
        int toReturn = this.vendingMachine.getCurrency().returnChange(vendingMachine.getAmountToPay(), vendingMachine.getCollectedCash());
        this.vendingMachine.setState(new ReadyState(vendingMachine));
        return toReturn;
    }

    @Override
    public Item dispenseItem(int productId, int count) {
        throw new RuntimeException("Dispensing cash cannot change items!");
    }

    @Override
    public int cancelTransaction() {
        throw new RuntimeException("Dispensing cash cannot cancel the transaction!");
    }
}
