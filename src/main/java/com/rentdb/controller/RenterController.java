package com.rentdb.controller;

import com.rentdb.model.Renter;
import com.rentdb.service.RenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RenterController {

    private final RenterService renterService;

    @GetMapping("/renters")
    public List<Renter> getRenters() {
        return renterService.getRenters();
    }

    @GetMapping("/renters/{renterId}")
    public Renter getRenters(@PathVariable long renterId) {
        return renterService.getRenter(renterId);
    }
}
