package com.rentdb.controller;

import com.rentdb.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    public final ReservationService reservationService;

}
