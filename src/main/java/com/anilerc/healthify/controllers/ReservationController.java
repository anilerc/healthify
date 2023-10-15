package com.anilerc.healthify.controllers;

import com.anilerc.healthify.models.Patient;
import com.anilerc.healthify.models.Reservation;
import com.anilerc.healthify.requests.CreateReservation;
import com.anilerc.healthify.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
@RestController
@RequestMapping("/reservations")
*/
public class ReservationController {

/*
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getReservations() {
        List<Reservation> reservations = reservationService.getReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping
    public void addReservation(@RequestBody CreateReservation body) {
        reservationService.addNewReservation(body);
    }
    */

}
