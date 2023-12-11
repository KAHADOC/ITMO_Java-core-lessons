package com.company.project.multithreading.lesson27;

import java.util.List;
public class ThreadTask extends Thread{
    private List<String> stringList;

    public ThreadTask(List<String> stringList) {
        this.stringList = stringList;
        System.out.println("Constructor " + Thread.currentThread().getName());
        this.setPriority(7);
    }

    public void printList(){
        stringList.forEach(System.out::println);
        // stringList.forEach(str -> System.out.println(str));
    }

    @Override
    public void run(){
        this.setPriority(10);
        System.out.println(Thread.currentThread().getName());
        printList();
    }
}
