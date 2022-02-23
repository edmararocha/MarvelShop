package com.example.marvelshop;

public class Shirt {
    private String title;
    private String info;
    private int price;

    private final int imageResource;

    Shirt(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.price = price;
        this.imageResource = imageResource;
    }

    // Getters

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getPrice() {
        return price;
    }

    public int getImageResource() {
        return imageResource;
    }
}
