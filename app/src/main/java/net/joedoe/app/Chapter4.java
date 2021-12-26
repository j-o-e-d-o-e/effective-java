package net.joedoe.app;

import net.joedoe.composition.InstrumentedSet;
import net.joedoe.immutability.Complex;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

    static void item18composition() {
        InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
        s.addAll(new HashSet<>(List.of("Snap", "Crackle", "Pop")));
        System.out.printf("Add count of %s: %d\n", s, s.getAddCount());
        // wrapper class can be used to instrument any Set implementation
        InstrumentedSet<Instant> t = new InstrumentedSet<>(new TreeSet<>());
        t.addAll(new HashSet<>(List.of(
                Instant.now(),
                Instant.now().plus(5L, ChronoUnit.MINUTES),
                Instant.now().plus(10L, ChronoUnit.MINUTES)
        )));
        System.out.printf("Add count of %s: %d\n", t, t.getAddCount());
    }
}
