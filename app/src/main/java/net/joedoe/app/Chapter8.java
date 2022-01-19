package net.joedoe.app;

import net.joedoe.defensivecopies.Period;
import net.joedoe.enums.operation.v2.item42.Operation;
import net.joedoe.optionals.Util;
import net.joedoe.streams.Anagrams;
import net.joedoe.streams.MersennePrimes;
import net.joedoe.streams.parallel.PrimeParallel;
import net.joedoe.varargs.Varargs;

import java.io.IOException;
import java.util.*;

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

    /**
     * Item 53: Use varargs judiciously
     */
    static void item53varargs() {
        int[] args = new int[]{4, 3, 2, 1};
        System.out.printf("Min of %s: %d%n", Arrays.toString(args),
                Varargs.min(args[0], Arrays.copyOfRange(args, 1, args.length)));
    }

    /**
     * Item 55: Return optionals judiciously
     */
    static void item55optionals() {
        List<Integer> nums = List.of(1, 2, 3);
        Optional<Integer> max = Util.max(nums);
        //noinspection OptionalGetWithoutIsPresent
        System.out.printf("Max in %s: %s%n", nums, max.get());

        nums = Collections.emptyList();
        max = Util.max(nums);
        System.out.printf("Max in %s: %s%n", nums, max.orElse(0));
    }
}
