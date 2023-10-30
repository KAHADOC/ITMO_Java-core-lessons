package com.company.project.lesson13.pwrappers;

import com.company.project.lesson08.Vehicle;

import java.lang.ref.WeakReference;
import java.util.Arrays;

public class PrimitiveWrappers {


    public static void main(String[] args) {
        String string = "Hello";
        WeakReference<String> stringWeakReference = new WeakReference<>(string);

        string = "other";

        int num = 567;
        Integer count = 34;
        // Integer count = new Integer(34);

        // автоупаковка - переменной класса-обертки
        // присваивается значение примитива
        Integer age = 20; // автоупаковка
        count = num; // // автоупаковка
        // автораспаковка - переменной примитивного типа
        // присваивается значение обертки
        double price;
        Double value = 45.6; // автоупаковка

        Float f = 78.5f; // автоупаковка
        price = f; // автораспаковка

        // Правила автоупаковки и автораспаковки
        // 1. автоупаковка не работает, если тип примитива не
        // соответствует классу обертке
        byte oneB = 1;
        // Integer oneI = oneB; // автоупаковка не сработает
        Integer oneI = (int) oneB;
        // 2. на автораспаковку правило №1 не распространяется
        // 3. аргументы методов подчиняются правилам
        // автоупаковки и автораспаковки
        printP(oneB, 45.7);
        // printW(oneB, 45.7);

        // 4. автоупаковка и автораспаковка
        // не работают с массивами
        Integer[] integers = {45, 67, 88};
        int[] ints = {45, 67, 88};
        // print(integers);
        print(ints);

        Integer x = 9;
        Integer y = 9;
        System.out.println(x == y); // true
        System.out.println(x.equals(y)); // true

        Integer k = 900;
        Integer l = 900;
        System.out.println(k == l); // false
        System.out.println(k.equals(l)); // true

        Number number = 800;
        if (number instanceof Integer i) System.out.println(i);
    }

    private static void print(int[] ints){
        System.out.println(Arrays.toString(ints));
    }

    private static void printW(Integer integerVar, Double doubleVar){
        System.out.println(integerVar);
        System.out.println(doubleVar);
    }

    private static void printP(int integerVar, double doubleVar){
        System.out.println(integerVar);
        System.out.println(doubleVar);
    }
}
