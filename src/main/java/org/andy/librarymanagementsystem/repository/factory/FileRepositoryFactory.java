package org.andy.librarymanagementsystem.repository.factory;

import org.andy.librarymanagementsystem.repository.BookRepository;
import org.andy.librarymanagementsystem.repository.BorrowRecordRepository;
import org.andy.librarymanagementsystem.repository.UserRepository;
import org.andy.librarymanagementsystem.repository.impl.FileBookRepositoryImplement;
import org.andy.librarymanagementsystem.repository.impl.FileBorrowRecordRepositoryImplement;
import org.andy.librarymanagementsystem.repository.impl.FileUserRepositoryImplement;

/**
 * @author Andy
 * @created 2024/1/27/027
 */
public class FileRepositoryFactory implements RepositoryFactory{
    @Override
    public  BookRepository getBookRepository() {
        return new FileBookRepositoryImplement();
    }
    @Override
    public  BorrowRecordRepository getBorrowRecordRepository() {
        return new FileBorrowRecordRepositoryImplement();
    }
    @Override
    public  UserRepository getUserRepositoryImplement() {
        return new FileUserRepositoryImplement();
    }

}
