package com.tbb.TheBlueBasil.services;

import com.tbb.TheBlueBasil.data.ReservationRepository;
import com.tbb.TheBlueBasil.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return null;
    }

    @Override
    public void saveReservation(Reservation reservation) {

    }

//    @Override
//    public Reservation getReservationById(long id) {
//        return null;
//    }

    @Override
    public void deleteReservationById(long id) {

    }

@Override
    public Reservation getReservationById(long id) {
        Optional< Reservation > optional = reservationRepository.findById(id);
        Reservation reservation = null;
        if (optional.isPresent()) {
            reservation = optional.get();
        } else {
            throw new RuntimeException(" No Reservation found for id :: " + id);
        }
        return reservation;
    }

}
