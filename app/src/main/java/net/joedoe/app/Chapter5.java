package net.joedoe.app;

import net.joedoe.genericmethods.Util;
import net.joedoe.generictypes.Stack;
import net.joedoe.typesafety.Chooser;
import net.joedoe.typesaftey.container.Favorites;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <strong>Title</strong>: Generics
 * <br>
 * <strong>Items</strong>: 26-33
 */
class Chapter5 {
    static void item28listsOverArrays() {
        Chooser<String> chooser1 = new Chooser<>(List.of("joe", "doe", "mary", "jane"));
        System.out.printf("Chosen: %s%n", chooser1.choose());

        Chooser<Number> chooser2 = new Chooser<>(List.of(1, 2, 3, 4)); // Item 31
        System.out.printf("Chosen: %s%n", chooser2.choose());
    }

    static void item29generictypes() {
        Stack<String> stack1 = new Stack<>();
        for (String s : List.of("mary", "jane")) stack1.push(s);
        while (!stack1.isEmpty()) System.out.printf("Pop: %s%n", stack1.pop().toUpperCase());

        Stack<Double> stack2 = new Stack<>(); // Item 31
        stack2.pushAll(List.of(Math.E, Math.PI));
        List<Double> list = new ArrayList<>();
        stack2.popAll(list);
        System.out.printf("Stack empty? %b, List: %s%n", stack2.isEmpty(), list);
    }

    static void item30genericmethods() {
        Set<String> names = Util.union(Set.of("joe", "doe"), Set.of("joey", "doe"));
        System.out.println(names);

        Set<Number> nums = Util.union(Set.of(1, 3, 5), Set.of(2.0, 4.0, 6.0)); // Item 31
        System.out.println(nums);

        Number num = Util.max(List.of(1, 2, 3));
        System.out.printf("Max: %s", num);
    }

    static void item33typesafeContainer() {
        Favorites fav = new Favorites();
        fav.putFavorite(String.class, "Joe");
        fav.putFavorite(Integer.class, 0xcafebabe);
        fav.putFavorite(Class.class, Favorites.class);
        String favoriteString = fav.getFavorite(String.class);
        int favoriteInteger = fav.getFavorite(Integer.class);
        Class<?> favoriteClass = fav.getFavorite(Class.class);
        System.out.printf("Favorites: %s, %x, %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
    }
}
