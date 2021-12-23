package net.joedoe.builder.pizza;

import java.util.Objects;

public class NyPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static class Builder extends Pizza.Builder<Builder> {
        // required
        private final Size size;

        // chain-start (public constructor)
        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        // chain-middle - helper
        protected Builder self() {
            return this;
        }

        @Override
        // chain-end (invokes private constructor)
        public NyPizza build() {
            return new NyPizza(this);
        }
    }

    @Override
    public String toString() {
        return "NyPizza{" +
                "size=" + size +
                ", toppings=" + toppings +
                '}';
    }
}
