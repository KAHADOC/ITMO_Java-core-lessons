package com.company.project.lesson2223.dao;

public class Cat {
    private final int number;
    private String color;
    public Cat(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
