package effectivejava.chapter2.item2.hierarchicalbuilder;

public class ManhattenPizza extends NyPizza {
    private final boolean organic;

    protected abstract static class AbstractBuilder<T extends ManhattenPizza.AbstractBuilder<T>> extends NyPizza.AbstractBuilder<T> {
        private boolean organic = false; // Default

        public AbstractBuilder(Size size) {
            super(size);
        }

        public T organic() {
            organic = true;
            return self();
        }

    }

    public static class Builder extends AbstractBuilder<Builder> {
        public Builder(Size size) {
            super(size);
        }
        @Override
        public ManhattenPizza build() {
            return new ManhattenPizza(this);
        }

    }

    protected ManhattenPizza(AbstractBuilder<?> builder) {
        super(builder);
        organic = builder.organic;
    }

}
