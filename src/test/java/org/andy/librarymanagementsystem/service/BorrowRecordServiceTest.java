package org.andy.librarymanagementsystem.service;

import org.andy.librarymanagementsystem.entity.BorrowRecord;
import org.andy.librarymanagementsystem.repository.BorrowRecordRepository;
import org.andy.librarymanagementsystem.repository.impl.InMemoryBorrowRecordRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Andy
 * @created 2024/1/17/017
 */
public class BorrowRecordServiceTest {
    private BorrowRecordService borrowRecordService;

    @Before
    public void setUp() {
        borrowRecordService = new BorrowRecordService(new InMemoryBorrowRecordRepository());
    }

    @Test
    public void testAddBorrowRecord() {
        borrowRecordService.borrowBook("testUser", "Test Book - Test Author", 1);

        assertTrue(borrowRecordService.getAllBorrowRecords().containsKey("Test Book - Test Author"));
        assertEquals(1, borrowRecordService.getAllBorrowRecords().get("Test Book - Test Author").getQuantity());
    }

    @Test
    public void testRemoveBorrowRecord() {
        borrowRecordService.borrowBook("testUser", "Test Book - Test Author", 1);

        borrowRecordService.returnBook("testUser", "Test Book - Test Author");

        assertFalse(borrowRecordService.getAllBorrowRecords().containsKey("testUser-Test Book - Test Author"));
    }
}
