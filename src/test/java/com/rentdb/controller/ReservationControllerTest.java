package com.rentdb.controller;

import com.rentdb.model.Reservation;
import com.rentdb.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReservationController.class)
class ReservationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ReservationService reservationService;

    Reservation reservation1 = new Reservation(0,1, 1, 1, 150.0, LocalDate.of(2000, 1, 1), LocalDate.of(2002, 1, 1));
    Reservation reservation2 = new Reservation(1,2, 4, 3, 555.55, LocalDate.of(2003, 2, 13), LocalDate.of(2004, 3, 5));

    @Test
    void addReservationTest() throws Exception {
        List<Reservation> reservations = new ArrayList<>(Arrays.asList(reservation1, reservation2));

        Mockito.when(reservationService.getReservations()).thenReturn(reservations);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/reservations")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].renterId", is(2)))
                .andExpect(jsonPath("$[1].tenantId", is(4)))
                .andExpect(jsonPath("$[1].itemId", is(3)))
                .andExpect(jsonPath("$[0].cost", is(150.0)))
                .andExpect(jsonPath("$[0].leaseStart", is("2000-01-01")))
                .andExpect(jsonPath("$[0].leaseEnd", is("2002-01-01")));
    }
}