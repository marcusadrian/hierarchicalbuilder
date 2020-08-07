package effectivejava.chapter2.item2.hierarchicalbuilder;

// Subclass with hierarchical builder (Page 15)
public class Calzone extends Pizza {
    private final boolean sauceInside;

    protected abstract static class AbstractBuilder<T extends Calzone.AbstractBuilder<T>>
            extends Pizza.AbstractBuilder<T> {
        private boolean sauceInside = false; // Default

        public T sauceInside() {
            sauceInside = true;
            return self();
        }
    }

    public static class Builder extends AbstractBuilder<Builder> {
        @Override
        public Calzone build() {
            return new Calzone(this);
        }
    }


    protected Calzone(AbstractBuilder<?> builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    @Override
    public String toString() {
        return String.format("Calzone with %s and sauce on the %s",
                toppings, sauceInside ? "inside" : "outside");
    }
}
