package com.company.project.lesson20.done.tasks;

import com.company.project.lesson14.properties.vehicle.*;
import java.util.List;

public class Lesson19Task02 {
    public static void main(String[] args) {
        List<Car> vehicles = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new MiniCar(Repaintable.Color.ORANGE, "002"),
                new MiniCar(Repaintable.Color.BLACK, "003"),
                new Car(Repaintable.Color.RED, "004"),
                new Car(Repaintable.Color.BLACK, "005"),
                new MiniCar(Repaintable.Color.ORANGE, "006")
        );

        List<String> task01 = vehicles.stream()
                .sorted((v01, v02) -> v02.getLevelOfWare() - v01.getLevelOfWare())
                .map(vehicle -> vehicle.getNumber())
                .toList();

       int task02 = vehicles.stream()
               .mapToInt(vehicle -> vehicle.getLevelOfWare())
               .sum();

       // task03
       vehicles.stream().peek(vehicle -> vehicle.changeColor(Repaintable.Color.GOLD))
               .forEach(vehicle -> System.out.println(vehicle));

    }
}
