package com.tbb.TheBlueBasil.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {


    @Test
    void getResName() {
        Reservation reservation = new Reservation("Ella","Braide", LocalDate.now(),  LocalTime.of(12,00,00), "1234567890", "ella@gmail.com", "4", "Table by the window");
        assertEquals("Ella", reservation.getResFirstName());
    }


}