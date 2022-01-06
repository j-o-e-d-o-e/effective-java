package net.joedoe.app;

import net.joedoe.generictypes.Stack;
import net.joedoe.typesafety.Chooser;

import java.util.List;

/**
 * <strong>Title</strong>: Generics
 * <br>
 * <strong>Items</strong>: 26-33
 */
class Chapter5 {
    static void item28listsOverArrays() {
        Chooser<String> chooser1 = new Chooser<>(List.of("joe", "doe", "mary", "jane"));
        System.out.printf("Chosen: %s\n", chooser1.choose());

        Chooser<Integer> chooser2 = new Chooser<>(List.of(1, 2, 3, 4));
        System.out.printf("Chosen: %d\n", chooser2.choose());
    }

    static void item29generictypes() {
        Stack<String> stack1 = new Stack<>();
        for (String s : List.of("mary", "jane")) stack1.push(s);
        while (!stack1.isEmpty()) System.out.printf("Pop: %s\n", stack1.pop().toUpperCase());

        Stack<Double> stack2 = new Stack<>();
        for (Double d : List.of(Math.E, Math.PI)) stack2.push(d);
        while (!stack2.isEmpty()) System.out.printf("Pop: %.2f\n", stack2.pop());
    }
}
