package com.company.project.lesson22.chain;

public class Animal {


    public void doAction(Action action) {
        action.executeNext(this);
    }
}
