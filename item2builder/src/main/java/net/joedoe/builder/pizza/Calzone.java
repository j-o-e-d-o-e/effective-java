package net.joedoe.builder.pizza;

public class Calzone extends Pizza {
    private final boolean sauceInside;

    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public static class Builder extends Pizza.Builder<Builder> {
        // optional, but with default
        private boolean sauceInside = false;

        // chain-middle
        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        // chain-middle - helper
        protected Builder self() {
            return this;
        }

        @Override
        // chain-end (invokes private constructor)
        public Calzone build() {
            return new Calzone(this);
        }
    }

    @Override
    public String toString() {
        return "Calzone{" +
                "sauceInside=" + sauceInside +
                ", toppings=" + toppings +
                '}';
    }
}
