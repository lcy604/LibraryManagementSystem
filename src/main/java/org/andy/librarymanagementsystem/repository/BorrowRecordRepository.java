package org.andy.librarymanagementsystem.repository;

import org.andy.librarymanagementsystem.entity.BorrowRecord;

import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public interface BorrowRecordRepository {
    boolean addBorrowRecord(BorrowRecord borrowRecord);

    boolean removeBorrowRecord(String username, String bookKey);

    Map<String, BorrowRecord> getAllBorrowRecords();
}
