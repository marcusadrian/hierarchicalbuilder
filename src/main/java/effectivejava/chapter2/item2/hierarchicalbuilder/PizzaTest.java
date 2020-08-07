package effectivejava.chapter2.item2.hierarchicalbuilder;

import static effectivejava.chapter2.item2.hierarchicalbuilder.Pizza.Topping.*;
import static effectivejava.chapter2.item2.hierarchicalbuilder.NyPizza.Size.*;

// Using the hierarchical builder (Page 16)
public class PizzaTest {
    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .glutenfree()
                .build();

        ManhattenPizza mhPizza = new ManhattenPizza.Builder(SMALL)
                .addTopping(HAM)
                .glutenfree()
                .organic()
                .build();


        System.out.println(nyPizza);
    }
}
