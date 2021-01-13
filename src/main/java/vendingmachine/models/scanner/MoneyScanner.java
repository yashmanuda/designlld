package vendingmachine.models.scanner;

public interface MoneyScanner {

    int scanMoney();

    default int scanMoney(int money) {
        return money;
    }
}
