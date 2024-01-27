package org.andy.librarymanagementsystem.repository.impl;

import org.andy.librarymanagementsystem.entity.User;
import org.andy.librarymanagementsystem.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Andy
 * @created 2024/1/17/017
 */
public class InMemoryUserRepositoryImplementTest {
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository = new InMemoryUserRepositoryImplement();
    }

    @Test
    public void testAddUser() {
        User user = new User("testUser", "password");
        assertTrue(userRepository.addUser(user));
        assertFalse(userRepository.addUser(user)); // Adding the same user again should return false
    }

    @Test
    public void testIsValidLogin() {
        User user = new User("testUser", "password");
        userRepository.addUser(user);

        assertTrue(userRepository.isValidLogin("testUser", "password"));
        assertFalse(userRepository.isValidLogin("testUser", "wrongPassword"));
        assertFalse(userRepository.isValidLogin("nonexistentUser", "password"));
    }

    @Test
    public void testFindUser() {
        User user = new User("testUser", "password");
        assertTrue(userRepository.addUser(user));
        assertNotNull(userRepository.findUser(user.getUsername()));
    }
}
