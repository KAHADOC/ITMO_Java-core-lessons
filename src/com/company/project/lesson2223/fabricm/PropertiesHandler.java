package com.company.project.lesson2223.fabricm;


public class PropertiesHandler extends AbstractHandler {

    public PropertiesHandler(String fileName) {
        super(fileName);
    }

    @Override
    public void write(String data) {
        System.out.println(data + "to PROPERTIES");
    }

}
