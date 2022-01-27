package net.joedoe.app;

import net.joedoe.serialize.*;
import net.joedoe.serialize.Period;

import java.util.Date;

/**
 * <strong>Title</strong>: Serialization
 * <br>
 * <strong>Items</strong>: 85-90
 */
class Chapter12 {
    /**
     * Item 88: Write readObject methods defensively
     */
    static void item88readObject() {
        MutablePeriod mp = new MutablePeriod();
        Period p = mp.period;
        System.out.printf("Before: %s%n", p);
        Date pEnd = mp.end;
        pEnd.setYear(69);
        System.out.printf("After:  %s%n", p);
    }
    /**
     * Item 90: Consider serialization proxies instead of serialized instances
     */
    static void item90serializeProxy() {
    }
}
