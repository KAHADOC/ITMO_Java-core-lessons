package com.company.project.lesson10.clonequals;

import java.util.Objects;

public class Item /* extends Object */ implements Cloneable{
    private final String name;
    private final double initialPrice;
    private double currentPrice;

    public Item(String name, double price) {
        this.name = name;
        this.initialPrice = price;
        this.currentPrice = price;
    }
    // геттеры + сеттер для currentPrice

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getName() {
        return name;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    @Override // System.out.println(item01.equals(item02));
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;

        if (Double.compare(initialPrice, item.initialPrice) != 0) return false;
        if (Double.compare(currentPrice, item.currentPrice) != 0) return false;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(initialPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(currentPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public Item /* Object */ clone(){
        // class Item implements Cloneable
        // CloneNotSupportedException
        try {
            return (Item) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", initialPrice=" + initialPrice +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
