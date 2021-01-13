package bloomfilter;

public class Main {
    public static void main(String[] args) {
        CustomBloomFilter<Integer> customBloomFilter = new CustomBloomFilter<>(10000);
        customBloomFilter.add(2544234);
        customBloomFilter.add(3422);

        // true positive
        System.out.println(customBloomFilter.mightContain(3422));

        // true negative
        System.out.println(customBloomFilter.mightContain(723));

        // even though 4234 was never added, it's a false positive
        // its hash function values are same as 2544234
        System.out.println(customBloomFilter.mightContain(4234));

        // will printChars the positives
        for (int i = 0; i < 100000; i++) {
            boolean mightContain = customBloomFilter.mightContain(i);
            if (mightContain) System.out.println(i);
        }
    }
}
