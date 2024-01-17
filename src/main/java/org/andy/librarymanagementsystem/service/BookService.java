package org.andy.librarymanagementsystem.service;

import org.andy.librarymanagementsystem.BookKeyUtil;
import org.andy.librarymanagementsystem.entity.Book;
import org.andy.librarymanagementsystem.repository.BookRepository;
import org.andy.librarymanagementsystem.repository.BorrowRecordRepository;

import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class BookService {
    private BookRepository bookRepository;
    private BorrowRecordRepository borrowRecordRepository;

    public BookService(BookRepository bookRepository, BorrowRecordRepository borrowRecordRepository) {
        this.bookRepository = bookRepository;
        this.borrowRecordRepository = borrowRecordRepository;
    }

    public Book addBook(String title, String author, int totalInventory) {
        return bookRepository.addBook(new Book(title, author, totalInventory));
    }

    public boolean deleteBook(String title, String author) {
        Book bookToDelete = bookRepository.getBook(title, author);

        if (bookToDelete != null) {
            // Check if the book is currently borrowed
            if (!borrowRecordRepository.getAllBorrowRecords().containsKey(BookKeyUtil.generateBookKey(bookToDelete))) {
                // Delete the book from the repository
                bookRepository.deleteBook(title, author);
                return true;
            }
        } else {
            System.out.println("Book \"" + title + "\" by " + author + " not found.");
        }

        return false;
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

    public boolean borrowBook(String title, String author) {
        Book book = getBook(title, author);
        if (book != null) {
            book.setCurrentInventory(0);
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

    public boolean returnBook(String title, String author) {
        Book book = getBook(title, author);
        if (book != null) {
            book.setCurrentInventory(book.getTotalInventory());
            return true;
        }
        return false;
    }
}
