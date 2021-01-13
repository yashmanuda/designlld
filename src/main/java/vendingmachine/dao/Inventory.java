package vendingmachine.dao;

import lombok.Getter;
import lombok.ToString;
import vendingmachine.exceptions.IncorrectProductCountException;
import vendingmachine.exceptions.InsufficientProductException;
import vendingmachine.exceptions.NoSuchProductException;
import vendingmachine.models.Item;
import vendingmachine.models.Product;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public class Inventory {
    private static Inventory INSTANCE;
    private Map<Integer, Integer> productIdToCount;
    private Map<Integer, Product> productIdToProduct;


    public static Inventory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Inventory();
        }
        return INSTANCE;
    }

    private Inventory() {
        this.productIdToCount = new HashMap<>();
        this.productIdToProduct = new HashMap<>();
    }


    public int addProduct(Product product, int count) {
        int productId = product.getId();
        productIdToCount.put(productId, productIdToCount.getOrDefault(productId, 0) + count);
        productIdToProduct.put(productId, product);
        return productIdToCount.get(productId);
    }


    public Item getItem(int productId, int count) throws Exception {
        if (count <= 0) throw new IncorrectProductCountException("Incorrect product count!");
        String productName = getProductName(productId);

        if (productIdToCount.get(productId) < count) {
            throw new InsufficientProductException(count + " number of " + productName + " unavailable");
        }

        int newCount = productIdToCount.get(productId) - count;
        productIdToCount.put(productId, newCount);

        return new Item(productIdToProduct.get(productId), count);
    }

    private String getProductName(int productId) throws NoSuchProductException {
        try {
            return productIdToProduct.get(productId).getName();
        } catch (Exception e) {
            throw new NoSuchProductException(productId + " unavailable!");
        }
    }

    public int getTotalPrice(int productId, int count) throws NoSuchProductException {
        if (!productIdToProduct.containsKey(productId)) throw new NoSuchProductException(productId + " unavailable!");
        return productIdToProduct.get(productId).getPrice() * count;
    }
}
