package com.tbb.TheBlueBasil.services;

import com.tbb.TheBlueBasil.models.Reservation;
import com.tbb.TheBlueBasil.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationServiceTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getReservationByEmail() {
        Reservation reservation = new Reservation();
        assertNull(reservation.getResEmail());
    }

    @Test
    void getReservationById() {
        Reservation reservation = new Reservation("Ella","Braide", LocalDate.now(),  LocalTime.of(12,00,00), "1234567890", "ella@gmail.com", "8", "Table by the window");
        assertNotNull(reservation.getId());
    }
}