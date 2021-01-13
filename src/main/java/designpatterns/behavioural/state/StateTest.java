package designpatterns.behavioural.state;

public class StateTest {

    public static void main(String[] args) {
        Context context = new Context();
        context.printName("Monday");
        context.printName("Tuesday");
        context.printName("Wednesday");
        context.printName("Thursday");
        context.printName("Friday");
        context.printName("Saturday");
        context.printName("Sunday");
    }
}
