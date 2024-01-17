package org.andy.librarymanagementsystem.service;

import org.andy.librarymanagementsystem.entity.Book;
import org.andy.librarymanagementsystem.repository.BookRepository;

import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title, String author, int totalInventory) {
        bookRepository.addBook(new Book(title, author, totalInventory));
    }

    public void deleteBook(String title, String author) {
        bookRepository.deleteBook(title, author);
    }

    public Book getBook(String title, String author) {
        return bookRepository.getBook(title, author);
    }

    public Map<String, Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public boolean borrowBook(String title, String author, int quantity) {
        Book book = getBook(title, author);
        if (book != null && book.getCurrentInventory() >= quantity) {
            book.setCurrentInventory(book.getCurrentInventory() - quantity);
            return true;
        }
        return false;
    }

    public boolean returnBook(String title, String author, int quantity) {
        Book book = getBook(title, author);
        if (book != null && (book.getCurrentInventory() + quantity) <= book.getTotalInventory()) {
            book.setCurrentInventory(book.getCurrentInventory() + quantity);
            return true;
        }
        return false;
    }
}
