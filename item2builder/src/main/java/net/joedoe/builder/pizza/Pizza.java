package net.joedoe.builder.pizza;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// Builder pattern for class hierarchies
public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        // chain-middle
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        // chain-middle - helper
        // Subclasses must override this method to return "this"
        protected abstract T self();

        // chain-end
        abstract Pizza build();
    }
}

