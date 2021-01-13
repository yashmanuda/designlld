package vendingmachine.models;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Item {
    private final Product product;
    private final int quantity;
}
