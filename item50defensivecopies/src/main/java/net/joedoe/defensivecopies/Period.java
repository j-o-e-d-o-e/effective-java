package net.joedoe.defensivecopies;

import java.util.Date;

// "Immutable" time period class with field instances of type `Date`
// easy fix: instead of `Date`, use `LocalDateTime` or `Instant` (both immutable)
public final class Period {
    private final Date start;
    private final Date end;

    /**
     * @param start the beginning of the period
     * @param end   the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException     if start or end is null
     */
    public Period(Date start, Date end) {
//        this.start = start;                   // unsafe
//        this.end = end;
        this.start = new Date(start.getTime()); // safe: makes defensive copies of parameters
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(this.start + " after " + this.end);
    }

    // Repaired accessors - make defensive copies of internal fields
    public Date start() {
//        return start;                         // unsafe
        return new Date(start.getTime());       // safe
    }

    public Date end() {
        return (Date) end.clone();              // safe: `end` is guaranteed to be of type `Date`
    }

    @Override
    public String toString() {
        return start + " TO " + end;
    }
}
