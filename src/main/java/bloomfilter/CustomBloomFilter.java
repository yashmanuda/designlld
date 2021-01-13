package bloomfilter;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class CustomBloomFilter<T> {

    private static final Integer BIT_SIZE = 6;

    // size of the bloom filter, should be at least 1
    private final int size;

    // size of this long array will be at least one
    // every item in this long array is basically 64-bit number (1s or 0s)
    private final long[] points;

    // hash functions that takes T and returns an integer hash value from 0 to (size - 1)
    private final List<ToIntFunction<T>> hashFunctions;

    CustomBloomFilter(final int size) {
        this.size = size;
        this.hashFunctions = Arrays.asList(
                multiplyAndModulo(29),
                multiplyAndModulo(17),
                multiplyAndModulo(13));

        // (size + 63) / 2^6
        this.points = new long[(size + (int) Math.pow(2, BIT_SIZE) - 1) >> BIT_SIZE];

    }

    /**
     * @param i input using which hash is to be calculated
     * @return returns number from 0 to (size - 1)
     */
    private ToIntFunction<T> multiplyAndModulo(final int i) {
        return t -> (t.hashCode() * i) % size;
    }

    public void add(T value) {
        for (ToIntFunction<T> function : hashFunctions) {
            // hash will be <= (size - 1)
            int hash = function.applyAsInt(value);

            // points[(hash / 2 ^ 6)] = points[(hash / 2 ^ 6)] OR 1 * 2 ^ (hash % 64)
            // we keep on taking OR of existing position value and new hash
            points[hash >>> BIT_SIZE] = points[hash >>> BIT_SIZE] | 1L << hash;
        }
    }

    public boolean mightContain(T value) {
        for (ToIntFunction<T> function : hashFunctions) {
            int hash = function.applyAsInt(value);
            if ((points[hash >>> BIT_SIZE] & (1L << hash)) == 0)
                return false;
        }
        return true;
    }
}
