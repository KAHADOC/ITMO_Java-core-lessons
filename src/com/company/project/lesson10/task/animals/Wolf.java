package com.company.project.lesson10.task.animals;

import java.util.Arrays;
import java.util.Objects;


public class Wolf extends WildAnimal{
    private final String[] likeToEat;
    private final String color;

    public Wolf(String[] likeToEat, String color) {
        this.likeToEat = likeToEat;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wolf wolf)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(likeToEat, wolf.likeToEat)) return false;
        return Objects.equals(color, wolf.color);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(likeToEat);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
