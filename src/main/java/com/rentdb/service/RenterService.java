package com.rentdb.service;

import com.rentdb.model.Renter;
import com.rentdb.repository.RenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RenterService {

    private final RenterRepository renterRepository;

    public List<Renter> getRenters() {
        return renterRepository.findAll();
    }

    public Renter getRenter(long renterId) {
        return renterRepository.findById(renterId).get();
    }
}
