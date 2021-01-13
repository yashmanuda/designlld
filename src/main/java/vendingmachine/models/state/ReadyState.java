package vendingmachine.models.state;

import vendingmachine.models.Item;
import vendingmachine.models.VendingMachine;
import vendingmachine.models.scanner.MoneyScanner;

public class ReadyState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        this.vendingMachine.setCollectedCash(null);
        this.vendingMachine.setAmountToPay(null);
    }


    public void collectCash(int paidAmount, MoneyScanner moneyScanner) {
        this.vendingMachine.setCollectedCash(moneyScanner.scanMoney(paidAmount));
        this.vendingMachine.setState(new DispenseItemState(vendingMachine));
    }

    @Override
    public int dispenseChange() {
        throw new RuntimeException("Waiting for money!");
    }

    @Override
    public Item dispenseItem(int productId, int count) {
        throw new RuntimeException("Waiting for money!");
    }

    @Override
    public int cancelTransaction() {
        throw new RuntimeException("Waiting for money!");
    }
}
