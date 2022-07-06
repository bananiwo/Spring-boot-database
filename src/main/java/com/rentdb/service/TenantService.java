package com.rentdb.service;

import com.rentdb.model.Reservation;
import com.rentdb.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

    public List<Reservation> getReservationsByTenantName(String tenantName) {
        return tenantRepository.findReservationByTenantName(tenantName);
    }
}
