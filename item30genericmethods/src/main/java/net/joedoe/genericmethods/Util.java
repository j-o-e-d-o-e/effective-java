package net.joedoe.genericmethods;

import java.util.*;

public class Util {

//    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
//        Set<E> result = new HashSet<>(s1);
//        result.addAll(s2);
//        return result;
//    }

    /**
     * <b>Item 31: use bounded wildcards to increase API flexibility</b>
     * <ul>
     * <li>parameterized types (`s1` and `s2`) represent producer, therefore >`<? extends E>`</li>
     * <li>here</li>
     * <ul>
     * <li>`s1` and `s2` produce `E` instances for use by method</li>
     * <li>allows for super-type `Number` and different sub-types</li>
     * </ul>
     */
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static <E extends Comparable<? super E>> E max(List<? extends E> c) {
        if (c.isEmpty()) throw new IllegalArgumentException("Empty collection");
        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0) result = Objects.requireNonNull(e);
        return result;
    }
}
