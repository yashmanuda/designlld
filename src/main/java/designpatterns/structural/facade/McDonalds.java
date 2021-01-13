package designpatterns.structural.facade;

import java.util.HashMap;
import java.util.Map;

public class McDonalds extends Hotel {
    public McDonalds() {
        name = "McDonald's";
    }

    @Override
    Map<String, Integer> getHotelMenu() {
        return new HashMap<String, Integer>() {{
            put("Burger", 10);
            put("Sandwich", 20);
        }};
    }
}
