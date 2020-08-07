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

        System.out.println(nyPizza);

        ManhattenPizza mhPizza = new ManhattenPizza.Builder(LARGE)
                .addTopping(HAM)
                .glutenfree()
                .organic()
                .build();

        System.out.println(mhPizza);

        Calzone calzone = new Calzone.Builder()
                .addTopping(MUSHROOM)
                .sauceInside()
                .build();

        System.out.println(calzone);

        SpicyCalzone spicyCalzone = new SpicyCalzone.Builder()
                .addTopping(ONION)
                .sauceInside()
                .spiceDegree(3)
                .build();

        System.out.println(spicyCalzone);


    }
}
