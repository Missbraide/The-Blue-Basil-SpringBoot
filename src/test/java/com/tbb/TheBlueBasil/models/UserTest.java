package com.tbb.TheBlueBasil.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    @Test
    void getEmail() {
        User user = new User("Arit", "Jack", "arit@gmail.com", "password");
        assertEquals("arit@gmail.com", user.getEmail());
    }

    @Test
    void getPassword() {
    }

    @Test
    void getReservations() {
    }
}