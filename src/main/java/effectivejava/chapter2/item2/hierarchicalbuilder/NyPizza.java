package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.Objects;

// Subclass with hierarchical builder (Page 15)
public class NyPizza extends Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;
    private final boolean glutenfree;

    protected abstract static class AbstractBuilder<T extends NyPizza.AbstractBuilder<T>>
            extends Pizza.AbstractBuilder<T> {

        private final Size size;
        private boolean glutenfree = false; // Default

        public AbstractBuilder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        public T glutenfree() {
            glutenfree = true;
            return self();
        }

    }

    public static class Builder extends AbstractBuilder<Builder> {
        public Builder(Size size) {
            super(size);
        }

        @Override public NyPizza build() {
            return new NyPizza(this);
        }

    }
    protected NyPizza(AbstractBuilder<?> builder) {
        super(builder);
        size = builder.size;
        glutenfree = builder.glutenfree;
    }

    @Override public String toString() {
        return size +
                (glutenfree ? " glutenfree" : "") +
                " New York Pizza with " +
                toppings;
    }
}
