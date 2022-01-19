package net.joedoe.streams.parallel;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class PrimeParallel {
    // Prime-counting stream pipeline - benefits from parallelization
    public static long piParallel(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    public static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }
}
