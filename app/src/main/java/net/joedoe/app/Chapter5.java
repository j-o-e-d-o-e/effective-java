package net.joedoe.app;

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
}
