package org.andy.librarymanagementsystem.repository.impl;

import org.andy.librarymanagementsystem.entity.Book;
import org.andy.librarymanagementsystem.repository.BookRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class InMemoryBookRepository implements BookRepository {
    private Map<String, Book> books = new HashMap<>(); // bookKey, Book

    @Override
    public void addBook(Book book) {
        String key = generateKey(book.getTitle(), book.getAuthor());
        if (books.containsKey(key)) {
            Book existingBook = books.get(key);
            existingBook.setTotalInventory(existingBook.getTotalInventory() + book.getTotalInventory());
            existingBook.setCurrentInventory(existingBook.getCurrentInventory() + book.getTotalInventory());
        } else {
            books.put(key, book);
        }
    }

    @Override
    public void deleteBook(String title, String author) {
        String key = generateKey(title, author);
        books.remove(key);
    }
    @Override
    public Book getBook(String title, String author) {
        String key = generateKey(title, author);
        return books.get(key);
    }

    @Override
    public Map<String, Book> getAllBooks() {
        return new HashMap<>(books);
    }

    private String generateKey(String title, String author) {
        return title + " - " + author;
    }
}
