package net.joedoe.typesafety;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {
    private final List<T> choiceList; // List instead of Array

//    public Chooser(Collection<T> choices) {
//        choiceList = new ArrayList<>(choices);
//    }

    /**
     * <b>Item 31: use bounded wildcards to increase API flexibility</b>
     * <ul>
     * <li>parameterized type (`choices`) represents a producer, therefore >`<? extends E>`</li>
     * <li>here</li>
     * <ul>
     * <li>`choices` produces `T` instances for use by the Chooser</li>
     * <li>allows for super-type `Number` and different sub-types</li>
     * </ul>
     * </ul>
     */
    public Chooser(Collection<? extends T> choices){
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
