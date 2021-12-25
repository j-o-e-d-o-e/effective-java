package net.joedoe.app;

import net.joedoe.equals.PhoneNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <strong>Title</strong>: Methods Common to All Objects
 * <br>
 * <strong>Items</strong>: 10-14
 */
class Chapter3 {
    static void item10equals() {
        PhoneNumber num1 = new PhoneNumber(353, 56, 1234);
        System.out.printf("%s equals %s? %s\n", num1, num1, num1.equals(num1));
        Object o = new Object();
        System.out.printf("%s equals %s? %s\n", num1, o, num1.equals(o));
        PhoneNumber num2 = new PhoneNumber(353, 56, 2345);
        System.out.printf("%s equals %s? %s\n", num1, num2, num1.equals(num2));
    }

    static void item11hashcode() {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(353, 56, 1234), "Joey");
        PhoneNumber num = new PhoneNumber(353, 56, 1234);
        System.out.printf("%s belongs to %s\n", num, m.get(num));
    }

    static void item14comparable() {
        PhoneNumber[] nums = new PhoneNumber[]{
                new PhoneNumber(353, 56, 1234),
                new PhoneNumber(131, 66, 1234),
                new PhoneNumber(353, 66, 1234),
        };
        for (PhoneNumber num : nums) System.out.println(num);
        Arrays.sort(nums);
        System.out.println("Sorted:");
        for (PhoneNumber num : nums) System.out.println(num);
    }
}
