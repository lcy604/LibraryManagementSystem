package org.andy.librarymanagementsystem.entity;
/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class Book {
    String title;
    String author;
    private int totalInventory;
    private int currentInventory;

    public Book(String title, String author, int totalInventory) {
        this.title = title;
        this.author = author;
        this.totalInventory = totalInventory;
        this.currentInventory =  totalInventory;
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

    public int getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(int totalInventory) {
        this.totalInventory = totalInventory;
    }

    public int getCurrentInventory() {
        return currentInventory;
    }

    public void setCurrentInventory(int currentInventory) {
        this.currentInventory = currentInventory;
    }

    public String toString() {
        return String.format("%s - %s - Inventory: %d", title, author, currentInventory);
    }
}
