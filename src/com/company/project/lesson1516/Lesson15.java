package com.company.project.lesson1516;

import com.company.project.lesson08.Vehicle;

import java.util.*;

/*public class LinkedList<E>
        implements List<E>, Deque<E>, Cloneable*/
public class Lesson15 {
    public static void main(String[] args) {


        Set<String> strings01 = new HashSet<>(
                Arrays.asList("Саратов", "Новгород")
        );
        strings01.add("Тверь");
        strings01.add("Москва");

        List<String> strings = new LinkedList<>(strings01);

        // int size = 3;
        // Node first = new Node("СПБ");
        // Node last = new Node("Москва");
        System.out.println(strings.size()); // ["Тверь", "Москва"]

        strings.add("СПБ");
        strings.add("Самара");
        strings.add(null);
        strings.add("Москва");
        strings.remove("Самара");
        strings.remove(3);

        // null<-new Node("СПБ"); <->
        // <-> new Node("Москва"); -> null

        ArrayList<String> stringArrayList = new ArrayList<>(40);
        // String[] i = new String[40];

        ArrayList<Integer> integers = new ArrayList<>();
        // integers.trimToSize();
        // Integer[] i = new Integer[10];
        System.out.println(integers.size()); // 2
        integers.add(3);
        integers.add(6);
        integers.add(90);
        integers.add(90);
        integers.add(90);

        // перебор коллекций
        // fori (только списки) /
        // foreach (любая коллекция) /
        // iterator (любая коллекция) /
        // вызов метода remove однопоточных коллекций
        // в циклах fori и foreach
        // приведет к исключению ConcurrentModificationException

        for (var integer : integers) {
            System.out.println(integer);
        }


        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element.toUpperCase());
            if ("самара".equalsIgnoreCase(element)) {
                iterator.remove();
            }
        }

        strings.removeIf(string -> string.equalsIgnoreCase("самара"));

        // ArrayList<Vehicle> vehicles = new ArrayList<>();
        // for (Vehicle vehicle : vehicles) {}










        // integers.add(null);


    }
}



