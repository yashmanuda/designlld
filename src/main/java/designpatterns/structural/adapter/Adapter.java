package designpatterns.structural.adapter;

/**
 * This is the adapter which not only implements IAdapter but also extends Adaptee
 * whose printString method is reused in this implementation
 */
public class Adapter extends Adaptee implements IAdapter {

    @Override
    public void printChars(char[] chars) {
        printString(new String(chars));
    }
}
