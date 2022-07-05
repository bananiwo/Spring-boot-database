package com.rentdb.service;

import com.rentdb.model.Reservation;
import com.rentdb.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public Reservation addReservation(Reservation reservation) {
        // check if lease period is at least 1 day long
        if(ChronoUnit.DAYS.between(reservation.getLeaseStart(), reservation.getLeaseEnd()) < 1) {
            throw new IllegalArgumentException("Lease is shorter than 1 day");
        }
        // check if periods of reservations with the same lease_item_id overlap
        boolean doPeriodsOverlap = false;
        List<Reservation> reservationsSameItemId = reservationRepository.findReservationByItemId(reservation.getItemId());
        for (Reservation other: reservationsSameItemId) {
            if(other.getLeaseStart().isBefore(reservation.getLeaseEnd()) &&
                other.getLeaseEnd().isAfter(reservation.getLeaseStart())){
                doPeriodsOverlap = true;
            }
        }
        if(doPeriodsOverlap) {
            throw new IllegalArgumentException("Item of reservation is alredy taken during this time");
        }

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    public Reservation editReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> findReservationByItemId(long itemId) {
        return reservationRepository.findReservationByItemId(itemId);
    }
}
