package org.andy.librarymanagementsystem.repository.impl;

import org.andy.librarymanagementsystem.BookKeyUtil;
import org.andy.librarymanagementsystem.entity.Book;
import org.andy.librarymanagementsystem.repository.BookRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class InMemoryBookRepositoryImplement implements BookRepository {
    private Map<String, Book> books = new HashMap<>(); // bookKey, Book

    @Override
    public Book addBook(Book book) {
        String key = BookKeyUtil.generateBookKey(book.getTitle(), book.getAuthor());
        if (books.containsKey(key)) {
            Book existingBook = books.get(key);
            existingBook.setTotalInventory(existingBook.getTotalInventory() + book.getTotalInventory());
            existingBook.setCurrentInventory(existingBook.getCurrentInventory() + book.getTotalInventory());
            return existingBook;
        } else {
            books.put(key, book);
            return book;
        }
    }

    @Override
    public void deleteBook(String title, String author) {
        String key = BookKeyUtil.generateBookKey(title, author);
        books.remove(key);
    }
    @Override
    public Book getBook(String title, String author) {
        String key = BookKeyUtil.generateBookKey(title, author);
        return books.get(key);
    }

    @Override
    public Map<String, Book> getAllBooks() {
        return new HashMap<>(books);
    }


}
