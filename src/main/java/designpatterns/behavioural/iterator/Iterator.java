package designpatterns.behavioural.iterator;

public interface Iterator<T> {
    boolean hasNext();

    T next();
}
