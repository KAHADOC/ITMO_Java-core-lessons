package com.company.project.lesson10.staticmodifier;

public class Bouquet {
    public int numberOfFlowers;
    public String type;

    // не €вл€ютс€ свойствами объектов
    public static int numberOfFlowersStatic;
    public static String typeStatic;

    static { // static блок
        // инструкции выполн€ютс€ один раз при загрузке класса
        // в программу
        // используетс€ дл€ инициализации static свойств,
        // возможен вызов static методов
        typeStatic = getType();
    }

    public double getPrice(){
        double price = Math.random() * 300 * numberOfFlowers;
        double priceWithStatic = Math.random() * 300 * numberOfFlowersStatic;
        return priceWithStatic;
    }

    // не определ€ют функционал объектов
    public /* final по умолчанию */ static double getPriceStatic(){
        // из static методов нельз€:
        // 1. обращатьс€ к не static свойствам
        // 2. вызывать не static методы
        // double price = Math.random() * 300 * this.numberOfFlowers; - ошибка
        // double price = getPrice(); - ошибка
        double priceWithStatic = Math.random() * 300 * numberOfFlowersStatic;
        return priceWithStatic;
    }

    private static String getType(){
        String[] types = {" руглый", " аскадный", "—пиральный"};
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


