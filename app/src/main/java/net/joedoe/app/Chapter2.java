package net.joedoe.app;

import net.joedoe.builder.NutritionFacts;
import net.joedoe.builder.pizza.Calzone;
import net.joedoe.builder.pizza.NyPizza;
import net.joedoe.builder.pizza.Pizza;

/**
 * <strong>Title</strong>: Creating and Destroying Objets
 * <br>
 * <strong>Items</strong>: 1-9
 */
class Chapter2 {
    static void item2builder() {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola);

        Pizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION).build();
        System.out.println(nyPizza);
        Pizza calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM).sauceInside().build();
        System.out.println(calzone);
    }
}
