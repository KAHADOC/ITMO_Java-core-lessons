package com.company.project.lesson10.task.images;


public class Gallery implements Drawable {
    private String name;
    private Drawable[] drawables;

    public Gallery(String name, Drawable[] drawables) {
        this.drawables = drawables;
        this.name = name;
    }

    public Drawable[] getImages() {
        return drawables;
    }

    @Override
    public void draw() {
        System.out.println(name);
        for (Drawable drawable : drawables) {
            drawable.draw();
        }
    }

    @Override
    public Drawable clone() {
        try {
            Gallery galleryCopy = (Gallery) super.clone();
            Drawable[] drawablesCopy = new Drawable[drawables.length];
            for (int i = 0; i < drawablesCopy.length; i++) {
                drawablesCopy[i] = drawables[i].clone();
            }
            galleryCopy.drawables = drawablesCopy;
            return galleryCopy;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}
