package com.tbb.TheBlueBasil.services;

import com.tbb.TheBlueBasil.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void getUserById() {
        User user = new User(999L, "Ella", "Braide", "ella@gmail.com", "password");
        assertEquals(999L, user.getId());


    }

@Test
    void getUserByWrongId() {
        User user = new User(756L, "Ella", "Braide", "ella@gmail.com", "password");
        assertNotEquals(765L, user.getId());
    }

    @Test
    void findByEmail() {
        User user = new User(756L, "Ella", "Braide", "ella@gmail.com", "password");
        assertEquals("ella@gmail.com", user.getEmail());
    }


}