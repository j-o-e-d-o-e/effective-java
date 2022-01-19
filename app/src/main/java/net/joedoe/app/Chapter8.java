package net.joedoe.app;

import net.joedoe.defensivecopies.Period;
import net.joedoe.enums.operation.v2.item42.Operation;
import net.joedoe.streams.Anagrams;
import net.joedoe.streams.MersennePrimes;
import net.joedoe.streams.parallel.PrimeParallel;

import java.io.IOException;
import java.util.Date;

/**
 * <strong>Title</strong>: Methods
 * <br>
 * <strong>Items</strong>: 49-56
 */
class Chapter8 {
    /**
     * Item 50: Make defensive copies when needed
     */
    static void item50defensiveCopies() {
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        System.out.printf("End: %s, Period: %s%n", end, p);
        end.setYear(78); // does not modify internals of p
        System.out.printf("End: %s, Period: %s%n", end, p);

        p.start().setYear(78);
        System.out.printf("End: %s, Period: %s%n", end, p);
    }
}
