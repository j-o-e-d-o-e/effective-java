package net.joedoe.app;

import net.joedoe.concatenation.UtilStringConcat;
import net.joedoe.decimalnums.UtilDecimal;
import net.joedoe.libraries.UtilFetch;

import java.io.IOException;

/**
 * <strong>Title</strong>: General Programming
 * <br>
 * <strong>Items</strong>: 57-68
 */
class Chapter9 {
    /**
     * Item 59: Know and use the libraries
     */
    static void item59libraries() {
        try {
            String[] args = new String[]{"https://traffic-tracker.herokuapp.com/api/days/current"};
            UtilFetch.main(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Item 60: Avoid float and double if exact answers are required
     */
    static void item60decimalNums() {
        System.out.printf("Broken:  %s%n", UtilDecimal.broken());
        System.out.printf("Fixed 1: %s%n", UtilDecimal.fixed1());
        System.out.printf("Fixed 2: %s%n", UtilDecimal.fixed2());
    }

    /**
     * Item 63: Beware the performance of string concatenation
     */
    static void item63stringConcatenation() {
        int numItems = 10_000;
        long start, end;
        String res;

        start = System.currentTimeMillis();
        res = UtilStringConcat.inappropriate(numItems);
        end = System.currentTimeMillis();
        System.out.printf("Inappropriate: \"...%s\" (%,dms)%n", res.substring(res.length() - 4), end - start);

        start = System.currentTimeMillis();
        res = UtilStringConcat.fixed(numItems);
        end = System.currentTimeMillis();
        System.out.printf("Fixed: \"...%s\" (%,dms)%n", res.substring(res.length() - 4), end - start);
    }
}
