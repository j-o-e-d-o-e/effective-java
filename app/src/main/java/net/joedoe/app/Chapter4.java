package net.joedoe.app;

import net.joedoe.immutability.Complex;

import static net.joedoe.immutability.Complex.*;

/**
 * <strong>Title</strong>: Classes and Interfaces
 * <br>
 * <strong>Items</strong>: 15-25
 */
class Chapter4 {
    static void item16immutability() {
        Complex c1 = valueOf(1, 0);
        System.out.printf("%s equals %s? %s\n", c1, ONE, c1.equals(ONE));
        System.out.printf("%s + %s = %s\n", ONE, ZERO, ONE.plus(ZERO));
        System.out.printf("%s - %s = %s\n", ONE, I, ONE.minus(I));
        System.out.printf("%s * %s = %s\n", ONE, I, ONE.times(I));
        System.out.printf("%s / %s = %s\n", ONE, I, ONE.dividedBy(I));
    }
}
