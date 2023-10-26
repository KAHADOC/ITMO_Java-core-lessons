package com.company.project.lesson10.staticmodifier;

public class Bouquet {
    public int numberOfFlowers;
    public String type;

    // не являются свойствами объектов
    public static int numberOfFlowersStatic;
    public static String typeStatic;

    static { // static блок
        // инструкции выполняются один раз при загрузке класса
        // в программу
        // используется для инициализации static свойств,
        // возможен вызов static методов
        typeStatic = getType();
    }

    public double getPrice(){
        double price = Math.random() * 300 * numberOfFlowers;
        double priceWithStatic = Math.random() * 300 * numberOfFlowersStatic;
        return priceWithStatic;
    }

    // не определяют функционал объектов
    public /* final по умолчанию */ static double getPriceStatic(){
        // из static методов нельзя:
        // 1. обращаться к не static свойствам
        // 2. вызывать не static методы
        // double price = Math.random() * 300 * this.numberOfFlowers; - ошибка
        // double price = getPrice(); - ошибка
        double priceWithStatic = Math.random() * 300 * numberOfFlowersStatic;
        return priceWithStatic;
    }

    private static String getType(){
        String[] types = {"Круглый", "Каскадный", "Спиральный"};
        return types[(int) (Math.random()*types.length)];
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "numberOfFlowers= " + numberOfFlowers +
                ", numberOfFlowersStatic= " + numberOfFlowersStatic +
                ", type='" + type + '\'' +
                ", typeStatic='" + typeStatic + '\'' +
                '}';
    }
}


