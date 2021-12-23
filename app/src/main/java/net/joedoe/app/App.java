package net.joedoe.app;

import net.joedoe.builder.NutritionFacts;
import net.joedoe.builder.pizza.*;

public class App {
    public static void main(String[] args) {
        App.item2builder();
    }

    private static void item2builder() {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola);

        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION).build();
        System.out.println(pizza);
        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM).sauceInside().build();
        System.out.println(calzone);
    }
}
