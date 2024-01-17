package org.andy.librarymanagementsystem;

import org.andy.librarymanagementsystem.entity.Book;

/**
 * @author Andy
 * @created 2024/1/17/017
 */
public class BookKeyUtil {
    private BookKeyUtil(){}


    public static String generateBookKey(Book book) {
        return book.getTitle()  + "-" + book.getAuthor();
    }

    public static String generateBookKey(String title, String author) {
        return title  + "-" + author;
    }
}
