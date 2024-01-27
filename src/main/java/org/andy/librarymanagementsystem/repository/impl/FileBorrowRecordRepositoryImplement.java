package org.andy.librarymanagementsystem.repository.impl;

import org.andy.librarymanagementsystem.entity.BorrowRecord;
import org.andy.librarymanagementsystem.repository.BorrowRecordRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class FileBorrowRecordRepositoryImplement implements BorrowRecordRepository {

    @Override
    public boolean addBorrowRecord(BorrowRecord borrowRecord) {
        // TODO: Add your code here
        throw new UnsupportedOperationException("someMethod is not yet implemented.");
    }
    @Override
    public boolean removeBorrowRecord(String username, String bookKey) {
        // TODO: Add your code here
        throw new UnsupportedOperationException("someMethod is not yet implemented.");
    }
    @Override
    public Map<String, BorrowRecord> getAllBorrowRecords() {
        // TODO: Add your code here
        throw new UnsupportedOperationException("someMethod is not yet implemented.");
    }
}
