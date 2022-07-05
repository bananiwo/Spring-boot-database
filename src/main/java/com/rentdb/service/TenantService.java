package com.rentdb.service;

import com.rentdb.model.Tenant;
import com.rentdb.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

    public List<Tenant> getTenants() {
        return tenantRepository.findAllTenants();
    }

    public Tenant getTenants(long tenantId) {
        return tenantRepository.findById(tenantId).get();
    }
}
