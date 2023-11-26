package com.company.project.lesson2223.builder;

import java.util.List;

public class NutritionFacts {
    private String number; // required
    private int calories; // required
    private int servings;
    private int fat;
    private String keyWords; // required

    private NutritionFacts(){}

    public static class Builder {
        private int calories;
        private int servings;
        private int fat;
        private String number;
        private List<String> keyWords;
        public Builder(String number) {
            this.number = number;
        }
        public Builder servings(String number){
            this.number = number;
            return this;
        }
        public Builder fat(int fat){
            this.fat = fat;
            return this;
        }

        public Builder keyWords(List<String> keyWords){
            this.keyWords = keyWords;
            return this;
        }

        public Builder servings(int servings){
            this.servings = servings;
            return this;
        }

        public Builder calories(int calories){
            this.calories = calories;
            return this;
        }

        public NutritionFacts build(){
            if (number == null || calories < 1
                    || keyWords == null || keyWords.size() == 0){
                throw new IllegalArgumentException();
            }
            NutritionFacts nf = new NutritionFacts();
            nf.number = number;
            nf.calories = calories;
            nf.servings = servings;
            nf.fat = fat;
            nf.keyWords = String.join(",", keyWords);
            return nf ;
        }
    }
}
