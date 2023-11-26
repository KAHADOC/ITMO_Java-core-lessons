package com.company.project.lesson2223.fabricm;

abstract public class AbstractHandler implements Handler {
    private String fileName;

    public AbstractHandler(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
