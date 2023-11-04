package com.company.project.lesson1516.task.fruits;
// remove(index)
// add(index, object)
public class Fruit {
    private final FruitType type;
    private double price;
    private int count;

    // конструктор, принимающий значения всех свойств + проверки

    // доступные геттеры и сеттеры

    // equals + hashCode + toString
    public enum FruitType {
        APPLE, PEAR, BANANA, APRICOT;
    }
}
