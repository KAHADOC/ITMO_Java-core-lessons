package com.company.project.lesson12.oop;

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Том");

        Dog dog = new Dog();
        dog.setName("Граф");

        Human human = new Human();
        human.catchAnimal(cat);
        human.catchAnimal(dog);
    }
}

abstract class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract String saySomething();
}

class Cat extends Animal {

    @Override
    String saySomething() {
        return "Мяу";
    }

    public void catchMouse(){
        System.out.println("логика метода catchMouse");
    }
}

class Dog extends Animal {

    @Override
    String saySomething() {
        return "Гав";
    }

    public void play(){
        System.out.println("логика метода play");
    }
}


class Human {
    private Animal[] animals = new Animal[10];

    // не важно, какой подтип Animal будет передан,
    // метод должен работать
    public void catchAnimal(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                // вызываем только методы супертипа (Animal), но не его подтипов
                // animal.play(); не объявлен в Animal
                // animal.catchMouse(); не объявлен в Animal
                System.out.println(animal.saySomething());
                animals[i] = animal;
            }
        }
    }
}