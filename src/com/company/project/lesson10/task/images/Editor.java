package com.company.project.lesson10.task.images;

public final class Editor {
    private Drawable drawable;

    public Editor(Drawable drawable) { // конструктор
        setDrawable(drawable);
    }

    public void setDrawable(final Drawable drawable){
        this.drawable = drawable;
    }

    public void show(){
        drawable.draw();
    }
}
