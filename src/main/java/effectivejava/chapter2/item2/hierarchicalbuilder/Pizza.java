package effectivejava.chapter2.item2.hierarchicalbuilder;
import java.util.*;

// Builder pattern for class hierarchies (Page 14)

// Note that the underlying "simulated self-type" idiom  allows for arbitrary fluid hierarchies, not just builders

public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    protected abstract static class AbstractBuilder<T extends AbstractBuilder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }
    }
    
    protected Pizza(AbstractBuilder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}
