package net.joedoe.enumset;

import java.util.Set;

// EnumSet - a modern replacement for bit fields
public class Text {
    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    // Any Set could be passed in, but EnumSet is clearly best
    public void applyStyles(Set<Style> styles) {
        System.out.printf("Styles applied: %s%n", styles);
    }
}
