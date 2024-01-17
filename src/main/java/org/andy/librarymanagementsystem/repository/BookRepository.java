package org.andy.librarymanagementsystem.repository;

import org.andy.librarymanagementsystem.entity.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public interface BookRepository {

    void addBook(Book book);

    void deleteBook(String title, String author);

    Book getBook(String title, String author);

    Map<String, Book> getAllBooks();
}
