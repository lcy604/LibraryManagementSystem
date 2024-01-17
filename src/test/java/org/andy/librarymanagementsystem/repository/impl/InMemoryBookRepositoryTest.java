package org.andy.librarymanagementsystem.repository.impl;

import org.andy.librarymanagementsystem.entity.Book;
import org.andy.librarymanagementsystem.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Andy
 * @created 2024/1/17/017
 */
public class InMemoryBookRepositoryTest {
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository = new InMemoryBookRepository();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Test Book", "Test Author", 5);
        bookRepository.addBook(book);

        assertTrue(bookRepository.getAllBooks().containsKey("Test Book - Test Author"));
        assertEquals(5, bookRepository.getAllBooks().get("Test Book - Test Author").getTotalInventory());
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book("Test Book", "Test Author", 5);
        bookRepository.addBook(book);

        bookRepository.deleteBook("Test Book", "Test Author");

        assertFalse(bookRepository.getAllBooks().containsKey("Test Book - Test Author"));
    }

    @Test
    public void testGetBook() {
        Book book = new Book("Test Book", "Test Author", 5);
        bookRepository.addBook(book);

        assertNotNull(bookRepository.getBook("Test Book", "Test Author"));
        assertNull(bookRepository.getBook("Nonexistent Book", "Nonexistent Author"));
    }
}
