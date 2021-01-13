package designpatterns.behavioural.observer;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Subject has all the observer references
 * As soon as subject changes state / receives input all the observers are updated
 */
public class Subject {
    private List<IObserver> observerList;

    Subject() {
        this.observerList = new ArrayList<>();
    }

    private void notifyAllObservers(String event) {
        observerList.forEach(observer -> observer.update(event));
    }

    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }


    public void scanSystemIn() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("exit")) return;
            notifyAllObservers(line);
        }
    }
}
