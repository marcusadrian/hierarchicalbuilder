package effectivejava.chapter2.item2.hierarchicalbuilder;

public class SpicyCalzone extends Calzone {

    private final int spiceDegree;

    protected abstract static class AbstractBuilder<T extends SpicyCalzone.AbstractBuilder<T>>
            extends Calzone.AbstractBuilder<T> {

        private int spiceDegree = 5; // Default

        public AbstractBuilder() {
            super();
        }

        public T spiceDegree(int spiceDegree) {
            this.spiceDegree = spiceDegree;
            return self();
        }
    }

    public static class Builder extends AbstractBuilder<SpicyCalzone.Builder> {
        public Builder() {
            super();
        }
        @Override
        public SpicyCalzone build() {
            return new SpicyCalzone(this);
        }

    }

    protected SpicyCalzone(AbstractBuilder<?> builder) {
        super(builder);
        spiceDegree = builder.spiceDegree;
    }

    @Override
    public String toString() {
        return super.toString() + " and a spice degree of " + spiceDegree;
    }


}
