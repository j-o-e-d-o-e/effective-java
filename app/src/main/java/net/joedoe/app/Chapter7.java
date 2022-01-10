package net.joedoe.app;

import net.joedoe.enums.operation.v2.item42.Operation;

/**
 * <strong>Title</strong>: Lambdas and Streams
 * <br>
 * <strong>Items</strong>: 42-48
 */
class Chapter7 {
    /**
     * Item 42: Prefer Lambdas to anonymous classes (using Enum `Operation` (v2) from item 34)
     */
    static void item42lambdas() {
        double op1 = 1.2;
        double op2 = 3.4;
        for (Operation op : Operation.values())
            if (op.ordinal() % 2 == 0)
                System.out.printf("%.2f %s %.2f = %.2f%n", op1, op, op2, op.apply(1.2, 3.4));
            else
                System.out.printf("%.2f %s %.2f = %.2f%n", op1, Operation.fromString(op.toString()).orElse(null), op2, op.apply(1.2, 3.4));
    }
}
