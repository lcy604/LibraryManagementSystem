package org.andy.librarymanagementsystem.service;

import org.andy.librarymanagementsystem.entity.BorrowRecord;
import org.andy.librarymanagementsystem.repository.BorrowRecordRepository;

import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class BorrowRecordService {
    private BorrowRecordRepository borrowRecordRepository;

    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
    }

    public boolean borrowBook(String username, String bookKey, int quantity) {
        return borrowRecordRepository.addBorrowRecord(new BorrowRecord(username, bookKey, quantity));
    }

    public boolean returnBook(String username, String bookKey) {
        return borrowRecordRepository.removeBorrowRecord(username, bookKey);
    }

    public Map<String, BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.getAllBorrowRecords();
    }
}
