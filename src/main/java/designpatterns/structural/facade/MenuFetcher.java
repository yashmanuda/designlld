package designpatterns.structural.facade;

import java.util.HashMap;
import java.util.Map;

/**
 * This the facade object responsible to do the work of fetching all the data from all the hotels
 * Client doesn't need to know what it is doing internally
 * Client will only call fetch all menus method
 */
public class MenuFetcher {
    private final KFC kfc = new KFC();
    private final McDonalds mcDonalds = new McDonalds();

    public Map<String, Integer> fetchAllMenus() {
        Map<String, Integer> menuOfAllHotels = new HashMap<>();
        menuOfAllHotels.putAll(kfc.getHotelMenu());
        menuOfAllHotels.putAll(mcDonalds.getHotelMenu());
        return menuOfAllHotels;
    }
}
