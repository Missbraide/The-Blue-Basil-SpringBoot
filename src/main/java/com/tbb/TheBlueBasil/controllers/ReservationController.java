package com.tbb.TheBlueBasil.controllers;


import com.tbb.TheBlueBasil.models.Reservation;
import com.tbb.TheBlueBasil.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller

public class ReservationController {

    @Autowired
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    //display list of reservations
    @GetMapping("/listReservations")
    public String viewReservationPage(Model model){
        model.addAttribute("listReservations", reservationService.getAllReservations());
        return "reservation-list";
    }

    @GetMapping("/showNewReservationForm")
    public String showNewReservationForm(Model model) {
        // create model attribute to bind form data
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        return "reservation";
    }
    @PostMapping("/saveReservation")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation) {
       log.info("New Reservation");
       log.info("Reservation before save {}", reservation);
        // save reservation to database
       reservationService.saveReservation(reservation);
        return "redirect:/listReservations";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get reservation from the service
        Reservation reservation = reservationService.getReservationById(id);

        // set reservation as a model attribute to pre-populate the form
        model.addAttribute("reservation", reservation);
        return "update_reservation";
    }

    @GetMapping("/deleteReservation/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.reservationService.deleteReservationById(id);
        return "redirect:/";
    }

}
