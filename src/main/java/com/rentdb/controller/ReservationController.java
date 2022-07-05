package com.rentdb.controller;

import com.rentdb.model.Reservation;
import com.rentdb.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    public final ReservationService reservationService;

    @GetMapping("/reservations")
    public List<Reservation> getReservations() { return reservationService.getReservations(); }

    @GetMapping("/reservations/items_leased/{itemId}")
    public List<Reservation> findReservationByItemId(@PathVariable long itemId) {
        return  reservationService.findReservationByItemId(itemId);
    }

    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping("/reservations")
    public Reservation editReservation(@RequestBody Reservation reservation) {
        return reservationService.editReservation(reservation);
    }

}
