package designpatterns.behavioural.observer;

public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.addObserver(event -> System.out.println("Received event: " + event));
        subject.scanSystemIn();
    }
}
