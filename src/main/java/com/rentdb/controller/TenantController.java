package com.rentdb.controller;

import com.rentdb.model.Reservation;
import com.rentdb.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @GetMapping("/tenants/name/{tenantName}/reservations")
    public List<Reservation> getReservationsByTenantName(@PathVariable String tenantName) {
        return tenantService.getReservationsByTenantName(tenantName);
    }
}
