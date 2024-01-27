package org.andy.librarymanagementsystem.repository.factory;

import org.andy.librarymanagementsystem.repository.BookRepository;
import org.andy.librarymanagementsystem.repository.BorrowRecordRepository;
import org.andy.librarymanagementsystem.repository.UserRepository;
import org.andy.librarymanagementsystem.repository.impl.InMemoryBookRepositoryImplement;
import org.andy.librarymanagementsystem.repository.impl.InMemoryBorrowRecordRepositoryImplement;
import org.andy.librarymanagementsystem.repository.impl.InMemoryUserRepositoryImplement;

/**
 * @author Andy
 * @created 2024/1/27/027
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {
    @Override
    public  BookRepository getBookRepository(){
        return  new InMemoryBookRepositoryImplement();
    }
    @Override
    public  BorrowRecordRepository getBorrowRecordRepository(){
        return  new InMemoryBorrowRecordRepositoryImplement();
    }
    @Override
    public  UserRepository getUserRepositoryImplement(){
        return  new InMemoryUserRepositoryImplement();
    }
}
