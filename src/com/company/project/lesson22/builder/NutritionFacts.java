package com.company.project.lesson22.builder;

public class NutritionFacts {
    private int calories;
    private int servings;
    private int fat;

    private NutritionFacts(Builder builder){
        calories = builder.calories;
        fat = builder.fat;
        servings = builder.servings;
    }

    public static class Builder {
        private int calories;
        private int servings;
        private int fat;
        public Builder(int calories) { // 120
            this.calories = calories;
        }
        public Builder servings(int servings){ // 30
            this.servings = servings;
            return this;
        }
        public Builder fat(int fat){
            this.fat = fat;
            return this;
        }
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }
}
