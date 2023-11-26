package com.company.project.lesson2223.composite;

public class AppImage extends Drawable{ // простые объекты - листья
    private String path;
    public AppImage(String path, String title) {
        super(title);
        this.path = path;
    }

    @Override
    void draw() {
        System.out.println("Image: " + title);
    }
}
