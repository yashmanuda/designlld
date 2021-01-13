package vendingmachine;

import vendingmachine.models.Item;
import vendingmachine.models.Product;
import vendingmachine.models.VendingMachine;
import vendingmachine.models.scanner.CashScanner;
import vendingmachine.models.scanner.MoneyScanner;

public class Driver {
    public static void main(String[] args) throws Exception {
        MoneyScanner scanner = new CashScanner();
        Product p1 = new Product("chips", 1, 10);
        Product p2 = new Product("juice", 2, 25);
        Product p3 = new Product("meal", 3, 50);


        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.getCurrency().addCurrency(100);
        vendingMachine.getInventory().addProduct(p1, 4);
        vendingMachine.getInventory().addProduct(p2, 3);
        vendingMachine.getInventory().addProduct(p3, 2);

        // valid transaction of 1 product
        vendingMachine.collectCash(40, scanner);
        Item item = vendingMachine.dispenseItem(1, 4);
        int returnedCash = vendingMachine.dispenseChange();
        System.out.println(item.toString());
        System.out.println(vendingMachine.getInventory());
        System.out.println(vendingMachine.getCurrency());
        System.out.println(returnedCash);
    }
}
