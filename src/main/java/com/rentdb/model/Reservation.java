package com.rentdb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "renter_id")
    private long renterId;
    @Column(name = "tenant_id")
    private long tenantId;
    @Column(name = "item_leased_id")
    private long itemId;
    private double cost;
    @Column(name = "lease_start")
    private LocalDate leaseStart;
    @Column(name = "lease_end")
    private LocalDate leaseEnd;
}
