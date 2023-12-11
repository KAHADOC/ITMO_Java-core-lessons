package com.company.project.multithreading.lesson27;


public class RunnableTask implements Runnable{
    private String string;

    public RunnableTask(String string) {
        this.string = string;
    }

    public void print(){
        System.out.println(string.toUpperCase());
    }
    @Override
    public void run() {
        print();
    }
}
