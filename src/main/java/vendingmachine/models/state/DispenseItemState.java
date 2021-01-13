package vendingmachine.models.state;

import vendingmachine.models.Item;
import vendingmachine.models.VendingMachine;
import vendingmachine.models.scanner.MoneyScanner;

public class DispenseItemState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public DispenseItemState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int paidAmount, MoneyScanner moneyScanner) {
        throw new RuntimeException("Waiting for product dispense!");
    }

    @Override
    public int dispenseChange() {
        throw new RuntimeException("Waiting for product dispense!");
    }

    @Override
    public Item dispenseItem(int productId, int count) throws Exception {
        int totalAmount = vendingMachine.getInventory().getTotalPrice(productId, count);
        vendingMachine.setAmountToPay(totalAmount);
        vendingMachine.setState(new DispenseChangeState(vendingMachine));
        return vendingMachine.getInventory().getItem(productId, count);
    }

    @Override
    public int cancelTransaction() {
        int toReturn = vendingMachine.getCollectedCash();
        vendingMachine.setState(new ReadyState(vendingMachine));
        return toReturn;
    }
}
