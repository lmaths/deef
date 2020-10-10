package com.rightside.deef.client.model;

public class Offer {

    private String storeName;
    private String payment;
    private double price;
    private String urlPhoto;

    public Offer(String storeName, String payment, double price, String urlPhoto) {
        this.storeName = storeName;
        this.payment = payment;
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
        return payment;
    }

    public void setSellerName(String payment) {
        this.payment = payment;
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
