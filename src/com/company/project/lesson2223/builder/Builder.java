package com.company.project.lesson2223.builder;

public class Builder {
    public static void main(String[] args) {
        // Строитель (Builder) позволяет создавать сложные объекты, дает большую гибкость, чем конструкторы.

        // 1. Builder накапливает значения свойств, необходимых NutritionFacts:
        // обязательные передаются в конструктор Builder, остальные передаются в методы fat, servings, carbs, proteins
        // 2. метод build создает и возвращает экземпляр NutritionFacts
        // 3. конструктор NutritionFacts должен быть private, т.к. экземпляры создаться только через Builder
        // 4. конструктор NutritionFacts принимает на вход экземпляр Builder,
        //  использует значения накопленных им (Builder) свойств,
        //  чтобы установить значения соответствующих свойств NutritionFacts
        // 5. значения свойств (необязательных) по умолчанию должны устанавливаться в Builder, не в NutritionFacts

        // 120 - калории
        NutritionFacts milk = new NutritionFacts.Builder("11yy")
                .fat(10)
                .build();

        // NutritionFacts meat = new NutritionFacts(300);
        // 300 - калории
        NutritionFacts meat = new NutritionFacts.Builder("51wd")
                .calories(300)
                .servings(200)
                .fat(80)
                .build();


    }
}
