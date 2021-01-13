package designpatterns.structural.adapter;

public class AdapterTest {
    public static void main(String[] args) {
        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};
        Adapter adapter = new Adapter();
        adapter.printChars(chars);
    }
}
