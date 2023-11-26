package com.company.project.lesson2223.fabricm;

public interface Handler {
    void write(String data);

    static Handler create(String filename){
        if (filename.endsWith(".txt")) return new TxtHandler(filename);
        if (filename.endsWith(".json")) return new JsonHandler(filename);
        if (filename.endsWith(".properties")) return new PropertiesHandler(filename);
        throw new IllegalArgumentException("Функционал для переданного расширения не предусмотрен");
    }
}