package com.company.project.lesson2223.fabricm;

public class FabricM {
    public static void main(String[] args) {
        Handler handler = Handler.create("file.txt");
        handler.write("данные");
    }
}
