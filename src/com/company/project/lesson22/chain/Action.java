package com.company.project.lesson22.chain;

abstract public class Action {
    private Action nextAction;

    public void nextAction(Action nextAction){
        this.nextAction = nextAction;
    }

    public void executeNext(Animal animal){
        this.execute(animal);
        if (this.nextAction != null)
            this.nextAction.executeNext(animal);
    }

    protected abstract void execute(Animal animal);
}
