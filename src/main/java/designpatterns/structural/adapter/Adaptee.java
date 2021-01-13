package designpatterns.structural.adapter;

/**
 * Existing capability of the system
 */
class Adaptee {
    void printString(String s) {
        System.out.println(s);
    }
}
