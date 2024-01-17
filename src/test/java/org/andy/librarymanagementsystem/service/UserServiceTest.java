package org.andy.librarymanagementsystem.service;

import org.andy.librarymanagementsystem.entity.User;
import org.andy.librarymanagementsystem.repository.UserRepository;
import org.andy.librarymanagementsystem.repository.impl.InMemoryUserRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Andy
 * @created 2024/1/17/017
 */
public class UserServiceTest {
    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService(new InMemoryUserRepository());
    }

    @Test
    public void testRegisterUser() {
        User user = new User("testUser", "password");
        assertTrue(userService.registerUser(user));
        assertFalse(userService.registerUser(user)); // Adding the same user again should return false
    }

    @Test
    public void testLoginUser() {
        User user = new User("testUser", "password");
        userService.registerUser(user);

        assertTrue(userService.loginUser("testUser", "password"));
        assertFalse(userService.loginUser("testUser", "wrongPassword"));
        assertFalse(userService.loginUser("nonexistentUser", "password"));
    }

    @Test
    public void testFindUser() {
        User user = new User("testUser", "password");
        assertTrue(userService.registerUser(user));
        assertNotNull(userService.findUser(user.getUsername()));
    }
}
