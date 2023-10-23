package com.company.project.lesson10.task.images;

public final class Editor {
    private Drawable drawable;

    public Editor(Drawable drawable) {
        setDrawable(drawable);
    }

    public void setDrawable(final Drawable drawable){
        this.drawable = drawable;
    }

    public void show(){
        drawable.draw();
    }

    @Override
    public Editor clone(){
        try {
            Editor editor = new Editor(drawable.clone());
            // Editor editor = super.clone();
            editor.drawable = (Drawable) super.clone();
            return (Editor) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
