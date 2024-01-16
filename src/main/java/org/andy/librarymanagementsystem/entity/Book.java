package org.andy.librarymanagementsystem.entity;

public class Book {
    String title;
    String author;
    int inventory;

    Book(String title, String author, int inventory) {
        this.title = title;
        this.author = author;
        this.inventory = inventory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
