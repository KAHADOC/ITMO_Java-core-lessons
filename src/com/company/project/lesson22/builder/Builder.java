package com.company.project.lesson22.builder;

public class Builder {
    public static void main(String[] args) {
        // 120 - калории
        NutritionFacts milk = new NutritionFacts.Builder(120)
                .fat(10)
                .build();

        // NutritionFacts meat = new NutritionFacts(300);
        // 300 - калории
        NutritionFacts meat = new NutritionFacts.Builder(300)
                .servings(200)
                .fat(80)
                .build();


    }
}
