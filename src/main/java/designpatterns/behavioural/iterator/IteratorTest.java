package designpatterns.behavioural.iterator;

import java.util.BitSet;

public class IteratorTest {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet(10);
        bitSet.set(2);
        bitSet.set(10);
        bitSet.set(13);
        bitSet.set(5, 6);

        BitSetIterator bitSetIterator = new BitSetIterator(bitSet);
        while (bitSetIterator.hasNext()) System.out.println(bitSetIterator.next());
    }
}
