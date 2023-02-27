package com.bikram.bitsandpizza;

import androidx.annotation.NonNull;

public class Pasta {
    String caption;
    int imageIds;
    public static final Pasta[] pastas = {new Pasta("Spaghetti Bolognaise",R.drawable.img),new Pasta("Lasagne",R.drawable.lasgane)};
    public String getCaption() {
        return caption;
    }

    public int getImageIds() {
        return imageIds;
    }

    public Pasta(String caption, int imageIds) {
        this.caption = caption;
        this.imageIds = imageIds;
    }

    @NonNull
    @Override
    public String toString() {
        return caption;
    }
}
