package designpatterns.behavioural.memento;

public class MementoTest {
    public static void main(String[] args) {
        Originator<String> originator = new Originator<>("state1");
        Caretaker<String> caretaker = new Caretaker<>();
        System.out.println("Start state: " + originator.getState());

        caretaker.addMemento(originator.getMemento());
        originator.setState("state2");
        System.out.println("Modified state: " + originator.getState());

        originator.restoreFromMemento(caretaker.getMemento(0));
        System.out.println("Restored state: " + originator.getState());
    }
}
