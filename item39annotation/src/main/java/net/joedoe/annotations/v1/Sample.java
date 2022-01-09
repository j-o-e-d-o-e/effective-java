package net.joedoe.annotations.v1;

import net.joedoe.annotations.Test;

public class Sample {
    @Test
    public static void m1() {           // Test should pass
        System.out.println("m1()");
    }

    public static void m2() {
        System.out.println("m2()");
    }

    @Test
    public static void m3() {           // Test should fail
        throw new RuntimeException("Boom");
    }

    public static void m4() {
        System.out.println("m4()");
    }

    @Test
    public void m5() {                  // INVALID USE: nonstatic method
        System.out.println("m5()");
    }

    public static void m6() {
        System.out.println("m6()");
    }

    @Test
    public static void m7() {           // Test should fail
        throw new RuntimeException("Crash");
    }

    public static void m8() {
        System.out.println("m8()");
    }
}

