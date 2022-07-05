package com.rentdb.controller;

import com.rentdb.model.Reservation;
import com.rentdb.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    public final ReservationService reservationService;

    @GetMapping("/reservations")
    public List<Reservation> getReservations() { return reservationService.getReservations(); }

    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }
}
