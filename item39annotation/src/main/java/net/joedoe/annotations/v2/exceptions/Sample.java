package net.joedoe.annotations.v2.exceptions;

import net.joedoe.annotations.ExceptionTest;

import java.util.ArrayList;
import java.util.List;

// Program containing annotations with a parameter
public class Sample {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {           // Test should pass
        System.out.println("m1()");
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() {           // Should fail (wrong exception)
        System.out.println("m2()");
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {           // Should fail (no exception)
        System.out.println("m3()");
    }

    // Code containing an annotation with an array parameter
    @ExceptionTest({IndexOutOfBoundsException.class, NullPointerException.class})
    public static void doublyBad() {
        System.out.println("doublyBad()");
        List<String> list = new ArrayList<>();
        list.addAll(5, null);   // The spec permits this method to throw either
    }                                   // IndexOutOfBoundsException or NullPointerException
}
