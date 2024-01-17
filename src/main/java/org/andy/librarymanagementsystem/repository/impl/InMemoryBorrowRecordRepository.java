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
        String key = generateBorrowRecordKey(borrowRecord.getUsername(), borrowRecord.getBookKey());
        if (!borrowRecords.containsKey(key)) {
            borrowRecords.put(key, borrowRecord);
            return true;
        }
        return false;
    }
    @Override
    public boolean removeBorrowRecord(String username, String bookKey) {
        String key = generateBorrowRecordKey(username, bookKey);
        if (borrowRecords.containsKey(key)) {
            borrowRecords.remove(key);
            return true;
        }
        return false;
    }
    @Override
    public Map<String, BorrowRecord> getAllBorrowRecords() {
        return new HashMap<>(borrowRecords);
    }
    @Override
    public String generateBorrowRecordKey(String username, String bookKey) {
        return username + "-" + bookKey;
    }
}
