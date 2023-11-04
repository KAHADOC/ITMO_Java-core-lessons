package com.company.project.lesson14.methods;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class GenericMethods {
    // Generic типы существуют только на этапе компиляции,
    // во время выполнения программы их не существует.
    // Generic компилируются в определенные типы

    // Стирание типов:
    // 1. Generic без ограничений компилируются в Object
    // 2. Generic c ограничениями компилируются в тип ограничения

    // Типизированные (generic) методы
    // могут принимать на вход и возвращать generic типы

    // generic без ограничений (unbounded)
    public static <T> boolean inArray(T[] array, T element){
        if (array == null || element == null) return false;
        for (T elem : array) {
            if (elem != null && elem.equals(element)) return true;
        }
        return false;
    }


    // generic с ограничениями (bounded)
    // T - компилируется в Number
    // K - компилируется в Temporal
    public static <T extends Number, K extends Temporal> int compareHashCodes(T first, K second){
        // у first можно вызвать методы Number и его супертипов
        // у second можно вызвать методы Temporal и его супертипов
        System.out.println(first.longValue());
        // 12 и единица измерения - часы
        System.out.println(second.plus(12, ChronoUnit.HOURS));
        // 12 часов
        System.out.println(second.plus(Duration.ofHours(12)));
        System.out.println();
        return Integer.compare(first.hashCode(), second.hashCode());
    }

    public static void main(String[] args) {
        String[] strings = {"red", "blue", "pink"};
        String string = "yellow";

        // <String> указывает на то, что в метод можно передать
        // указанный тип и его подтипы
        boolean res = GenericMethods.<String>inArray(strings, string);

        Integer[] integers = {45, 89, 0, 34, -1};
        Integer integer = 3;

        // <Number> указывает на то, что в метод можно передать
        // указанный тип и его подтипы
        res = GenericMethods.<Number>inArray(integers, integer);
                            //<Object>
        res = GenericMethods.inArray(integers, string);

        int result = GenericMethods.<Number, LocalDate>compareHashCodes(integer, LocalDate.now());
    }
}
