package com.company.project.lesson22.strategy;

public class Run implements IAction<Unit> {
    @Override
    public void execute(Unit unit) {
        System.out.println("unit Run");
    }
}
