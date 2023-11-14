package com.company.project.lesson18;

@FunctionalInterface
public interface Operation {
    double action(double a, double b);

    default Operation addOperation(Operation other){
        return (first, second) -> action(first, second) + other.action(first, second);
    }
}
