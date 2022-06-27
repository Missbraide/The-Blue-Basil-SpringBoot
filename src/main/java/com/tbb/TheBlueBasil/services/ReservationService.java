package com.tbb.TheBlueBasil.services;

import com.tbb.TheBlueBasil.models.Reservation;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface ReservationService {
    List<Reservation> getAllReservations();
    void saveReservation(Reservation reservation);
    Reservation getReservationById(long id);
    void deleteReservationById(long id);



}
