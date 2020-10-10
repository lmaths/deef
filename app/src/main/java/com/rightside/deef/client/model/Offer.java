package com.rightside.deef.client.model;

public class Offer {

    private String storeName;
    private String sellerName;
    private double price;
    private String urlPhoto;

    public Offer(String storeName, String sellerName, double price, String urlPhoto) {
        this.storeName = storeName;
        this.sellerName = sellerName;
        this.price = price;
        this.urlPhoto = urlPhoto;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
