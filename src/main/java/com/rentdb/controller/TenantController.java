package com.rentdb.controller;

import com.rentdb.model.Tenant;
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

    @GetMapping("/tenants")
    public List<Tenant> getTenants() {
        return tenantService.getTenants();
    }

    @GetMapping("/tenants/{tenantId}")
    public Tenant getTenants(@PathVariable long tenantId) {
        return tenantService.getTenants(tenantId);
    }
}
