package designpatterns.structural.facade;

import java.util.Map;

public abstract class Hotel {
    protected String name;

    abstract Map<String, Integer> getHotelMenu();
}
