package designpatterns.structural.facade;

import java.util.HashMap;
import java.util.Map;

public class KFC extends Hotel {
    public KFC() {
        name = "KFC";
    }

    @Override
    public Map<String, Integer> getHotelMenu() {
        return new HashMap<String, Integer>() {{
            put("Fries", 10);
            put("Chicken Wings", 20);
            put("Soda", 5);
        }};
    }
}
