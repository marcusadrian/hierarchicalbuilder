package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.Objects;

// Subclass with hierarchical builder (Page 15)
public class NyPizza extends Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;
    private final boolean glutenfree;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;
        private boolean glutenfree = false; // Default

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        public Builder glutenfree() {
            glutenfree = true;
            return this;
        }

        @Override public NyPizza build() {
            return new NyPizza(this);
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
        glutenfree = builder.glutenfree;
    }

    @Override public String toString() {
        return "New York Pizza with " + toppings;
    }
}
