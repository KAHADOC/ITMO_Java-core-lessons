package com.company.project.lesson22.strategy;

public class Unit {
    private IAction<Unit> action;

    public Unit(IAction<Unit> action) {
        if (action == null) throw new IllegalArgumentException();
        this.action = action;
    }

    public void changeAction(IAction<Unit> action){
        if (action != null) this.action = action;
    }

    public void move(){
        action.execute(this);
    }
}
