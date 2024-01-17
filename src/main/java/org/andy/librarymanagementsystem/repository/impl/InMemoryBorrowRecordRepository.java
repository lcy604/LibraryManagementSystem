package org.andy.librarymanagementsystem.repository.impl;

import org.andy.librarymanagementsystem.entity.BorrowRecord;
import org.andy.librarymanagementsystem.repository.BorrowRecordRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class InMemoryBorrowRecordRepository implements BorrowRecordRepository {
    private Map<String, BorrowRecord> borrowRecords = new HashMap<>(); // username-bookKey, BorrowRecord

    @Override
    public boolean addBorrowRecord(BorrowRecord borrowRecord) {
        if (!borrowRecords.containsKey(borrowRecord.getBookKey())) {
            borrowRecords.put(borrowRecord.getBookKey(), borrowRecord);
            return true;
        }
        return false;
    }
    @Override
    public boolean removeBorrowRecord(String username, String bookKey) {
        if (borrowRecords.containsKey(bookKey)) {
            borrowRecords.remove(bookKey);
            return true;
        }
        return false;
    }
    @Override
    public Map<String, BorrowRecord> getAllBorrowRecords() {
        return new HashMap<>(borrowRecords);
    }
}
