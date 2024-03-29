package com.example.mylibrary;

public class Book {
    private int id;
    private String name;
    private String author;
    private String imageUrl;
    private int pages;
    private String shortDesc;
    private String longDesc;
    private boolean isExpanded;

    public boolean isExpanded() {
        return isExpanded;
    }

    public Book(boolean isExpanded) {
        this.isExpanded = isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public Book(int id, String name, String author, String imageUrl, int pages, String shortDesc, String longDesc) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.imageUrl = imageUrl;
        this.pages = pages;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        isExpanded = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", pages=" + pages +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                '}';
    }
}
