package net.joedoe.app;

import net.joedoe.builder.NutritionFacts;

public class App {
    public static void main(String[] args) {
        App.item2builder();
    }

    private static void item2builder() {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println("Result: " + cocaCola.toString());
    }
}
