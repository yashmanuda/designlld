package designpatterns.behavioural.iterator;

import java.util.BitSet;
import java.util.NoSuchElementException;

/**
 * Iterator exposes two methods next & hasNext
 * No matter what the similar collection is you can iterate over it
 */
public class BitSetIterator implements Iterator<Boolean> {
    private final BitSet bitset;
    private int index;

    BitSetIterator(BitSet bitset) {
        this.bitset = bitset;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bitset.length();
    }

    @Override
    public Boolean next() {
        if (index >= bitset.length()) {
            throw new NoSuchElementException();
        }
        return bitset.get(index++);
    }
}
