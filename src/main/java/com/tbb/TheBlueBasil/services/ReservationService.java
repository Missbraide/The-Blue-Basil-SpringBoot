package com.tbb.TheBlueBasil.services;

import com.tbb.TheBlueBasil.data.ReservationRepository;
import com.tbb.TheBlueBasil.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ReservationService {


    @Autowired
    private ReservationRepository reservationRepository;


    public List<Reservation> getAllReservations() {
        return  reservationRepository.findAll();
    }


    public void saveReservation(Reservation reservation) {
        this.reservationRepository.save(reservation);

    }


//    public Reservation getReservationById(long id) {
//        return null;
//    }


    public void deleteReservationById(long id) {
        this.reservationRepository.deleteById(id);

    }


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


    public void saveOrUpdate(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Transactional(rollbackOn = {NoSuchElementException.class})
    public Reservation findById(Long id) throws NoSuchElementException{
        return reservationRepository.findById(id).orElseThrow();
    }
}
