package com.rentdb.service;

import com.rentdb.model.Reservation;
import com.rentdb.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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
        if(isDateTaken(reservation, reservation.getLeaseStart(), reservation.getLeaseEnd())) {
            throw new IllegalArgumentException("Item of reservation is already taken during this time");
        }

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> findReservationByItemId(long itemId) {
        return reservationRepository.findReservationByItemId(itemId);
    }

    @Transactional
    public void updateReservation(long reservationId, Double cost, LocalDate leaseStart, LocalDate leaseEnd) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalStateException("Reservation with id " + reservationId + " does not exist"));

        if(cost != null && cost > 0) {
            reservation.setCost(cost);
        }

        // validate leastStart and leaseEnd if present
        if(leaseStart != null && leaseEnd != null){
            if(ChronoUnit.DAYS.between(leaseStart, leaseEnd) < 1) {
                throw new IllegalArgumentException("Lease is shorter than 1 day");
            }
            if(isDateTaken(reservation, leaseStart, leaseEnd)){
                throw new IllegalArgumentException("Item of reservation is already taken during this time");
            }
            reservation.setLeaseStart(leaseStart);
            reservation.setLeaseEnd(leaseEnd);
        }
        else if(leaseStart != null){
            if(ChronoUnit.DAYS.between(leaseStart, reservation.getLeaseEnd()) < 1) {
                throw new IllegalArgumentException("Lease is shorter than 1 day");
            }
            if(isDateTaken(reservation, leaseStart, reservation.getLeaseEnd())) {
                throw new IllegalArgumentException("Item of reservation is already taken during this time");
            }
            reservation.setLeaseStart(leaseStart);
        }
        else if(leaseEnd != null) {
            if( ChronoUnit.DAYS.between(reservation.getLeaseStart(), leaseEnd) <1) {
                throw new IllegalArgumentException("Lease is shorter than 1 day");
            }
            if(isDateTaken(reservation, reservation.getLeaseStart(), leaseEnd)){
                throw new IllegalArgumentException("Item of reservation is already taken during this time");
            }
            reservation.setLeaseEnd(leaseEnd);
        }
    }

    boolean ifDatesOverlap(LocalDate firstStart, LocalDate firstEnd, LocalDate secondStart, LocalDate secondEnd) {
        return firstStart.isBefore(secondEnd) && firstEnd.isAfter(secondStart);
    }

    boolean isDateTaken(Reservation reservation, LocalDate leaseStart, LocalDate leaseEnd) {
        boolean isTaken = false;
        List<Reservation> reservationsSameItemId = reservationRepository.findReservationByItemId(reservation.getItemId());

        for (Reservation other: reservationsSameItemId) {
            if(other.equals(reservation)) {
                continue;
            }
            if (ifDatesOverlap(leaseStart, leaseEnd,
                    other.getLeaseStart(), other.getLeaseEnd())) {
                isTaken = true;
            }
        }
        return isTaken;
    }
}
