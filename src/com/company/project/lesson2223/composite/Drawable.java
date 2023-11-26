package com.company.project.lesson2223.composite;

abstract public class Drawable { // общий тип для простых и сложных объектов
    protected String title;

    public Drawable(String title) {
        this.title = title;
    }

    abstract void draw();
}
