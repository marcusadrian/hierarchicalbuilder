package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.Objects;

public class ManhattenPizza extends NyPizza {
    private final boolean organic;

    public static class Builder extends NyPizza.Builder<ManhattenPizza.Builder> {
        private boolean organic = false; // Default

        public Builder(Size size) {
            super(size);
        }

        public NyPizza.Builder organic() {
            organic = true;
            return this;
        }
        @Override public NyPizza build() {
            return new ManhattenPizza(this);
        }
    }

    private ManhattenPizza(Builder builder) {
        super(builder);
        organic = builder.organic;
    }

}
