package com.tbb.TheBlueBasil.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {


    @Test
    void getResFirstName() {
        Reservation reservation = new Reservation("Ella","Braide", LocalDate.now(),  LocalTime.of(12,00,00), "1234567890", "ella@gmail.com", "4", "Table by the window");
        assertEquals("Ella", reservation.getResFirstName());
    }


    @Test
    void getResNoOfGuests() {
        Reservation reservation = new Reservation("Ella","Braide", LocalDate.now(),  LocalTime.of(12,00,00), "1234567890", "ella@gmail.com", "8", "Table by the window");
        assertEquals("8", reservation.getResNoOfGuests());
    }


    @Test
    void getWrongResLastName(){
        Reservation reservation = new Reservation("Ella","Braide", LocalDate.now(),  LocalTime.of(12,00,00), "1234567890", "ella@gmail.com", "8", "Table by the window");
        assertNotEquals("Teller", reservation.getResLastName());

    };
}