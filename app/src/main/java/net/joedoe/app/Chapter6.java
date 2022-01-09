package net.joedoe.app;

import net.joedoe.annotations.v2.exceptions.RunTests2;
import net.joedoe.enummap.Phase;
import net.joedoe.enummap.Plant;
import net.joedoe.enums.Operation;
import net.joedoe.enums.PayrollDay;
import net.joedoe.enums.Planet;
import net.joedoe.enumset.Text;
import net.joedoe.instance.fields.Ensemble;

import java.util.*;

/**
 * <strong>Title</strong>: Enums and Annotations
 * <br>
 * <strong>Items</strong>: 34-41
 */
class Chapter6 {
    /**
     * Item 34: Use enums instead of int constants
     */
    static void item34enums() {
        double earthWeight = 80;
        System.out.printf("%.2f kg on %s weight ...%n", earthWeight, Planet.EARTH.name());
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            if (p.ordinal() == 2) continue;
            System.out.printf("\t%.2f kg on %s%n", p.surfaceWeight(mass), p);
        }

        double op1 = 1.2;
        double op2 = 3.4;
        for (Operation op : Operation.values())
            if (op.ordinal() % 2 == 0)
                System.out.printf("%.2f %s %.2f = %.2f%n", op1, op.toString(), op2, op.apply(1.2, 3.4));
            else
                System.out.printf("%.2f %s %.2f = %.2f%n", op1, Operation.fromString(op.toString()).orElse(null), op2, op.apply(1.2, 3.4));
        for (Operation op : Operation.values()) System.out.printf("Inverse of %s: %s%n", op, inverse(op));

        int minutesWorked = 123;
        int payRate = 2;
        System.out.printf("%d minutes of work pay ...%n", minutesWorked);
        for (PayrollDay p : PayrollDay.values()) System.out.printf("\t%d€, on %s%n", p.pay(minutesWorked, payRate), p);
    }

    // Item34 (example for usefulness of switch-statement on client-side)
    private static Operation inverse(Operation op) {
        switch (op) {
            case PLUS:
                return Operation.MINUS;
            case MINUS:
                return Operation.PLUS;
            case TIMES:
                return Operation.DIVIDE;
            case DIVIDE:
                return Operation.TIMES;
            default:
                throw new AssertionError("Unknown op: " + op);
        }
    }

    /**
     * Item 35: Use instance fields instead of ordinals
     */
    static void item35enumsInstanceFields() {
        for (Ensemble e : Ensemble.values())
            if (e.numberOfMusicians() == 1) System.out.printf("%d musician is in a %s%n", e.numberOfMusicians(), e);
            else System.out.printf("%d musicians are in a %s%n", e.numberOfMusicians(), e);
    }

    /**
     * Item 36: Use EnumSet instead of bit fields (client-side)
     */
    static void item36enumSets() {
        new Text().applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.UNDERLINE));
    }

    /**
     * Item 37: Use EnumMap instead of ordinal indexing (client-side)
     */
    static void item37enumMaps() {
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) plantsByLifeCycle.put(lc, new HashSet<>());
        Plant[] garden = new Plant[]{
                new Plant("strawberry", Plant.LifeCycle.ANNUAL),
                new Plant("raspberry", Plant.LifeCycle.ANNUAL),
                new Plant("wild berry", Plant.LifeCycle.PERENNIAL)
        };
        for (Plant p : garden) plantsByLifeCycle.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle);

        for (Phase from : Phase.values()) {
            for (Phase to : Phase.values()) {
                if (to.equals(from)) continue;
                Phase.Transition transition = Phase.Transition.from(from, to);
                System.out.printf("%s: from %s to %s%n", transition, from, to);
            }
        }
    }

    /**
     * Item 39: Prefer annotations to naming patters
     */
    static void item39annotations() {
        try {
//            RunTests1.main(new String[]{"net.joedoe.annotations.v1.Sample"});
            RunTests2.main(new String[]{"net.joedoe.annotations.v2.exceptions.Sample"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
