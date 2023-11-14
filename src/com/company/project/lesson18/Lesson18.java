package com.company.project.lesson18;

import com.company.project.lesson1516.task.fruits.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Lesson18 {

    private String string = "String";
    private static String staticString = "Static String";

    public void accessFromLambda(/*final*/ String argString) {
        /*final*/
        String localString = "Local String";
        /*final*/
        Fruit localFruit = new Fruit(Fruit.FruitType.APRICOT, 300, 4);

        BinaryOperator<?> access = (first, second) -> {
            // в лямбда выражениях есть доступ к свойствам (static и non-static) для чтения и записи
            // в лямбда выражениях есть доступ к локальным переменным метода только для чтения

            System.out.println(string);
            System.out.println(staticString);
            System.out.println(argString);
            System.out.println(localString);
            string = "Новая строка";
            staticString = "Новая строка";
            // argString = "Новая строка";
            // localString = "Новая строка";
            // localFruit = new Fruit(Fruit.FruitType.APPLE, 120, 2);
            localFruit.setCount(localFruit.getCount() + 10);

            // затенение свойств
            // локальные переменные затенить нельзя
            String string = "shadowing";
            System.out.println(string); // "shadowing"
            return 0;
        };
    }

    public static void main(String[] args) {

        /*
         Лямбда синтаксис позволяет
         создать класс, реализующий функциональный интерфейс и
         его экземпляр в несколько строчек кода.
         */

        /*
         Функциональный интерфейс - интерфейс, который содержит один абстрактный и
         любое количество default и static методов.
         Принято добавлять аннотацию @FunctionalInterface.
         @FunctionalInterface - аннотация времени компиляции, компилятор сообщит об ошибке,
         если в интерфейсе будет объявлено больше одного абстрактного метода.
         */

/*
TODO:
        @FunctionalInterface
        public interface InterfaceName<T> {
            T abstractMethod(T firstArg, T secondArg);
        }

         Лямбда синтаксис:
         1. создаёт анонимный класс, имплементирующий InterfaceName
         2. реализация абстрактного метода: (str01, str02) -> (str01 + str02).toUpperCase()
         3. создаёт экземпляр данного класса
TODO:   InterfaceName<String> object = (str01, str02) -> (str01 + " " + str02).toUpperCase();

         Далее можно обратиться к object, как к обычному объекту,
         вызвать доступные методы (всегда определены интерфейсом)
TODO:    String str = object.abstractMethod("lambda", "java 8");

        Можно объявить любое количество реализаций
TODO:   InterfaceName<String> object01 = (str01, str02) -> str01.toUpperCase() + ": " + str02.toLowerCase();
        InterfaceName<Integer> object02 = (int01, int02) -> {
            if (int01 > 0) return int01 + int02;
            return int01 - int02;
        };
        */

        /*
        Лямбда выражение состоит из:
        1. стрелка -> - лямбда
        2. слева от -> - аргументы, которые принимает абстрактный метод интерфейса
        3. справа от -> - тело метода
        */

        /*
        Аргументы:
        1. если метод не принимает на вход аргументы или принимает 2 и более аргументов,
        они ДОЛЖНЫ указываться в () скобках;
        2. если метод принимает на вход 1 аргумент, () скобки МОЖНО опустить;
        3. типы данных аргументов компилятор берет из контекста (абстрактного метода функционального интерфейса)
        */

        /*
        Тело метода и возвращаемое значение:
        1. если тело метода состоит из одной инструкции, его МОЖНО не оборачивать в {} скобки;
        2. если тело метода состоит из нескольких инструкции, оно ДОЛЖНО оборачиваться в {} скобки;
        3. если тело метода не оборачивается в {} скобки, то метод неявно возвращает результат (return не пишем);
        4. если тело метода оборачивается в {} скобки, то для возврата результата необходимо явно указать return
        5. тип возвращаемого значения или void компилятор берет из контекста (абстрактного метода функционального интерфейса)
         */

        /*
        Функциональные интерфейсы, объявленные в java, находятся в пакете java.util.function:
         Predicate<T> + boolean test(T t);
         Function<T, R> + R apply(T t);
         Consumer<T> + void accept(T t);
         и т.д
         */

//        double first = 90.0;
//        double second = 40.0;
//        first + second;

        // Operation: double action(double a, double b);
        Operation plus = (first, second) -> first + second;
        System.out.println(plus);
        System.out.println(plus.action(34.6, 90));

        /*
        public class Plus implements Operation {

            @Override
            public double action(double first, double second) {
                return first + second;
            }
        }
        Operation plus = new Plus();
        plus.action(45, 90);
        */

        // Написать реализации для:
        // 1. умножения
        Operation sub = (first, second) -> first * second;

        // 2. вычитания
        Operation minus = (first, second) -> first - second;

        // 3. деления
        Operation div = (first, second) -> {
            if (second == 0) throw new IllegalArgumentException("second не должен быть 0");
            return first / second;
        };

        System.out.println(sub.action(34.6, 90));
        System.out.println(minus.action(34.6, 90));
        System.out.println(div.action(34.6, 90));

        Operation min = (a, b) -> a < b ? a : b;

        // объекты, созданные через лямбда, можно передавать в методы,
        // как любые другие экземпляры
        printOperationResult(min, 12.3, 9.9);
        printOperationResult((a, b) -> a > b ? a : b, 12.3, 9.9);

        Operation operation = plus
                .addOperation(minus)
                .addOperation(div)
                .addOperation(sub);

        System.out.println(operation.action(12.4, 5.7));

        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(875, -78, 12, 56, 34, -89, 0, 344));
        // Predicate<T>: boolean test(T t)
        Predicate<Integer> negative = elem -> elem < 0;
        integers.removeIf(negative);

        Predicate<Integer> equals1000 = integer -> integer == 1000;
        integers.removeIf(equals1000);
        // или без переменной:
        integers.removeIf(integer -> integer == 1000);

        /*
         Iterator<Integer> iterator = integers.iterator();
         while (iterator.hasNext()){
             if (negative.test(iterator.next())) iterator.remove();
         }
        */

        ArrayList<String> files = new ArrayList<>(Arrays.asList("01.txt", "01.bin", "02.json", "03.txt", "04.txt", "05.properties"));
        // оставить в списке только названия с расширениями json и properties
        // использовать метод removeIf
        files.removeIf(string -> !(string.endsWith(".json") || string.endsWith(".properties")));

        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 5));
        fruits.add(new Fruit(Fruit.FruitType.BANANA, 80, 12));
        fruits.add(new Fruit(Fruit.FruitType.APRICOT, 300, 2));
        fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 10));
        fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 2));
        fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 8));
        fruits.add(new Fruit(Fruit.FruitType.BANANA, 130, 8));
        // удалить из списка только фрукты с типом BANANA дешевле 100
        // использовать метод removeIf
        // interface Predicate
        // public boolean removeIf(Predicate filter)
        // boolean test(T t);
        Predicate<Fruit> byType = fruit -> fruit.getType() == Fruit.FruitType.BANANA;
        Predicate<Fruit> byPrice = fruit -> fruit.getPrice() < 100;
        Predicate<Fruit> filter = byType.and(byPrice);
        fruits.removeIf(filter);


        // Consumer<T>: void accept(T t);
        // 1. вывести в консоль стоимость фруктов с типами BANANA и APPLE
        fruits.forEach(fruit -> {
            if (fruit.getType() == Fruit.FruitType.BANANA ||
                    fruit.getType() == Fruit.FruitType.APPLE) {
                System.out.println(fruit.getPrice());
            }
        });
        // 2. увеличить стоимость каждого фрукта в 2 раза
        fruits.forEach(line -> line.setPrice(line.getPrice() * 2));


        /*
         Реализовать static метод, который принимает ArrayList fruits
         и Predicate filter, содержащий условие фильтрации.
         Метод возвращает список фруктов,
         которые прошли проверку переданным filter.
         (метод должен работать с фруктами и их подтипами)
         */
        Predicate<Fruit> filter01 = fruit -> fruit.getPrice() > 100;
        filter01.test(new Fruit(Fruit.FruitType.BANANA, 233, 10));




         /*
         Учитывая, что Comparator - функциональный интерфейс,
         отсортировать список фруктов:
         1. по цене
         2. по цене и количеству
        */

        Comparator<Fruit> compareByPrice = (a, b) -> (int) (a.getPrice() - b.getPrice());
        Comparator<Fruit> compareByCount = (f1, f2) -> f2.getCount() - f1.getCount();
        Comparator<Fruit> compareByType = (f1, f2) -> f1.getType().ordinal() - f2.getType().ordinal();
        fruits.sort(compareByPrice);
        fruits.sort(compareByPrice.thenComparing(compareByCount));


        // Interface: Notification
        // абстрактный метод send(User user);
        // default Notification additionalSend(Notification notification, Predicate predicate)


        // Interface: IPay
        // абстрактный boolean pay();
        // default метод IPay additionalPay(IPay pay)
        // альтернативный способ используется,
        // если предыдущий не сработал
    }

    // Predicate<T> boolean test(T t)
    private static <T extends Fruit> ArrayList<T> fruitsByFilter(ArrayList<T> fruits, Predicate<? super T> filter){
        ArrayList<T> fruitArrayList = new ArrayList<>();
        for (T fruit : fruits) {
            if (filter.test(fruit)) fruitArrayList.add(fruit);
        }
        return fruitArrayList;
    }


    public static void printOperationResult(Operation operation, double a, double b) {
        System.out.println(operation.action(a, b));
    }
}
