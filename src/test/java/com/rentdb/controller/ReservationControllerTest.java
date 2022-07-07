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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReservationController.class)
class ReservationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ReservationService reservationService;

    Reservation reservation1 = new Reservation(0,1, 1, 1, 150.0, LocalDate.of(2000, 1, 1), LocalDate.of(2002, 1, 1));
    Reservation reservation2 = new Reservation(1,2, 1, 1, 250.0, LocalDate.of(2001, 1, 1), LocalDate.of(2001, 1, 1));

    @Test
    void findReservationsByItemIdTest() throws Exception {
        List<Reservation> reservationsItemId1 = new ArrayList<>(Arrays.asList(reservation1, reservation2));

        Mockito.when(reservationService.findReservationByItemId(Mockito.anyLong())).thenReturn(reservationsItemId1);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/reservations/items_leased/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].renterId", is(1)))
                .andExpect(jsonPath("$[0].tenantId", is(1)))
                .andExpect(jsonPath("$[0].itemId", is(1)))
                .andExpect(jsonPath("$[1].itemId", is(1)))
                .andExpect(jsonPath("$[1].cost", is(250.0)))
                .andExpect(jsonPath("$[1].leaseStart", is("2001-01-01")))
                .andExpect(jsonPath("$[1].leaseEnd", is("2001-01-01")));
    }
}