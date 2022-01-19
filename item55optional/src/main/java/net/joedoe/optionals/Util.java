package net.joedoe.optionals;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Util {
    // Returns maximum value in collection as an Optional<E>
    // Optional instead of Exception Handling, like in item 30 (favor generic methods)

//    public static <E extends Comparable<? super E>> E max(List<? extends E> c)
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        if (c.isEmpty()) return Optional.empty(); // DIFFERENCE TO ITEM 30: does not return `null` nor throws exception
        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0) result = Objects.requireNonNull(e);
        return Optional.of(result);
    }
}
