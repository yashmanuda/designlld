package designpatterns.behavioural.mediator;

public class MediatorTest {
    public static void main(String[] args) {
        Mediator<Integer> mediator = new Mediator<>();
        mediator.setValue("Reliance", 2310);
        mediator.setValue("HDFC", 2000);
        mediator.getValue("HDFC").ifPresent(x -> System.out.println("Price of HDFC is: " + x));
        mediator.addObserver("Reliance", () -> System.out.println("New price of reliance is: " + mediator.getValue("Reliance").orElseThrow(RuntimeException::new)));
        mediator.setValue("Reliance", 2500);
    }
}
