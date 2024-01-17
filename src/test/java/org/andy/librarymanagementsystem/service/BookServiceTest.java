package org.andy.librarymanagementsystem.service;

import org.andy.librarymanagementsystem.entity.Book;
import org.andy.librarymanagementsystem.repository.BookRepository;
import org.andy.librarymanagementsystem.repository.impl.InMemoryBookRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Andy
 * @created 2024/1/17/017
 */
public class BookServiceTest {
    private BookService bookService;

    @Before
    public void setUp() {
        bookService = new BookService(new InMemoryBookRepository());
    }

    @Test
    public void testAddBook() {
        bookService.addBook("Test Book", "Test Author", 5);

        assertTrue(bookService.getAllBooks().containsKey("Test Book - Test Author"));
        assertEquals(5, bookService.getAllBooks().get("Test Book - Test Author").getTotalInventory());
    }

    @Test
    public void testDeleteBook() {
        bookService.addBook("Test Book", "Test Author", 5);

        bookService.deleteBook("Test Book", "Test Author");

        assertFalse(bookService.getAllBooks().containsKey("Test Book - Test Author"));
    }

    @Test
    public void testGetBook() {
        bookService.addBook("Test Book", "Test Author", 5);

        assertNotNull(bookService.getBook("Test Book", "Test Author"));
        assertNull(bookService.getBook("Nonexistent Book", "Nonexistent Author"));
    }
}
