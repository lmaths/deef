package com.rightside.deef.client.model;

public class Comment {
    private String name;
    private String text;
    private String urlPhoto;

    public Comment(String name, String text, String urlPhoto) {
        this.name = name;
        this.text = text;
        this.urlPhoto = urlPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
