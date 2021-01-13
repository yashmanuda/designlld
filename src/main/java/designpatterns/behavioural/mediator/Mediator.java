package designpatterns.behavioural.mediator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Storage<T> can only be accessed via this Mediator
 *
 * @param <T> Storage type
 */
public class Mediator<T> {
    private Map<String, Storage<T>> storageMap = new HashMap<>();
    private Map<String, List<Runnable>> storageObservers = new ConcurrentHashMap<>();

    public void setValue(String storageName, T value) {
        Storage<T> storage = storageMap.computeIfAbsent(storageName, name -> new Storage<>());
        storage.setValue(this, storageName, value);
    }

    public Optional<T> getValue(String storageName) {
        return Optional.ofNullable(storageMap.get(storageName)).map(Storage::getValue);
    }

    public void addObserver(String storageName, Runnable observer) {
        storageObservers.computeIfAbsent(storageName, x -> new CopyOnWriteArrayList<>()).add(observer);
    }

    /**
     * @param storageName observers of storageName will be notified
     */
    public void notifyAllObservers(String storageName) {
        if (storageObservers.containsKey(storageName)) {
            for (Runnable runnable : storageObservers.get(storageName)) {
                runnable.run();
            }
        }
    }
}
