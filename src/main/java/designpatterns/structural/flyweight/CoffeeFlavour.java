package designpatterns.structural.flyweight;

import lombok.ToString;

import java.util.WeakHashMap;

/**
 * CoffeeFlavour is the flyweight object
 */
@ToString
class CoffeeFlavour {
    private final String name;
    private static final WeakHashMap<String, CoffeeFlavour> CACHE = new WeakHashMap<>();

    // only getFlavour() can call this constructor
    private CoffeeFlavour(String name) {
        this.name = name;
    }

    /**
     * This is the flyweight factory method which checks if object is already existing or not
     *
     * @param name name of the coffee flavour
     * @return existing instance of coffee flavour or new one
     */
    public static CoffeeFlavour getFlavour(String name) {
        synchronized (CACHE) {
            return CACHE.computeIfAbsent(name, CoffeeFlavour::new);
        }
    }

    public static int flavoursInCache() {
        synchronized (CACHE) {
            return CACHE.size();
        }
    }
}
