package com.prm392.ego_flask.models;

public class Bottle {
    private String Id;
    private String Name;
    private int SoldQuantity;
    private double Price;
    private String ImageUrl;
    private String NapColor;
    private String QuaiColor;
    private String BinhColor;

    //Getters
    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public int getSoldQuantity() {
        return SoldQuantity;
    }

    public double getPrice() {
        return Price;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getNapColor() {
        return NapColor;
    }

    public String getQuaiColor() {
        return QuaiColor;
    }

    public String getBinhColor() {
        return BinhColor;
    }

    //Setters
    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSoldQuantity(int soldQuantity) {
        SoldQuantity = soldQuantity;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public void setNapColor(String napColor) {
        NapColor = napColor;
    }

    public void setQuaiColor(String quaiColor) {
        QuaiColor = quaiColor;
    }

    public void setBinhColor(String binhColor) {
        BinhColor = binhColor;
    }
}