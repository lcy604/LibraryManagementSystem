package org.andy.librarymanagementsystem.entity;
/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class BorrowRecord {
    private String username;
    private String bookKey;
    private int quantity;

    public BorrowRecord(String username, String bookKey, int quantity) {
        this.username = username;
        this.bookKey = bookKey;
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookKey() {
        return bookKey;
    }

    public void setBookKey(String bookKey) {
        this.bookKey = bookKey;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
