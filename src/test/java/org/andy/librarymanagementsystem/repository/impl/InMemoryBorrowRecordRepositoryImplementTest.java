package org.andy.librarymanagementsystem.repository.impl;

import org.andy.librarymanagementsystem.entity.BorrowRecord;
import org.andy.librarymanagementsystem.repository.BorrowRecordRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Andy
 * @created 2024/1/17/017
 */
public class InMemoryBorrowRecordRepositoryImplementTest {
    private BorrowRecordRepository borrowRecordRepository;

    @Before
    public void setUp() {
        borrowRecordRepository = new InMemoryBorrowRecordRepositoryImplement();
    }

    @Test
    public void testAddBorrowRecord() {
        BorrowRecord borrowRecord = new BorrowRecord("testUser", "Test Book - Test Author", 1);
        borrowRecordRepository.addBorrowRecord(borrowRecord);

        assertTrue(borrowRecordRepository.getAllBorrowRecords().containsKey("Test Book - Test Author"));
        assertEquals(1, borrowRecordRepository.getAllBorrowRecords().get("Test Book - Test Author").getQuantity());
    }

    @Test
    public void testRemoveBorrowRecord() {
        BorrowRecord borrowRecord = new BorrowRecord("testUser", "Test Book - Test Author", 1);
        borrowRecordRepository.addBorrowRecord(borrowRecord);

        borrowRecordRepository.removeBorrowRecord("testUser", "Test Book - Test Author");

        assertFalse(borrowRecordRepository.getAllBorrowRecords().containsKey("testUser-Test Book - Test Author"));
    }
}
