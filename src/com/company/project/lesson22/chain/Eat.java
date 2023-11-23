package com.company.project.lesson22.chain;

public class Eat extends Action{
    @Override
    protected void execute(Animal animal) {
        System.out.println("Eat");
    }
}