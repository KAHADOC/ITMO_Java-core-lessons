package com.company.project.lesson2223.strategy;

public class Walk implements IAction<Unit>{

    @Override
    public void execute(Unit unit) {
        System.out.println("unit Walk");
    }
}
