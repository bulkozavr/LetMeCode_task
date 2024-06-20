package com.example.authandstories;

public class Article {
    private String title; // заголовок
    private String text;  // текст статьи
    private int pictResource; // ресурс картинки

    public Article(String name, String capital, int flag){

        this.title =name;
        this.text =capital;
        this.pictResource =flag;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPictResource() {
        return this.pictResource;
    }

    public void setPictResource(int pictResource) {
        this.pictResource = pictResource;
    }
}
