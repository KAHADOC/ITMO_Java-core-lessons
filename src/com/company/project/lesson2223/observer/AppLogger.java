package com.company.project.lesson2223.observer;

public class AppLogger implements Listener{ // конкретная реализация наблюдателя
    @Override
    public void execute(Connection connection) {
        System.out.println("Запись информации в файл");
    }
}
