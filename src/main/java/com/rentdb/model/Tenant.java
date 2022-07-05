package com.rentdb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tenant {

    @Id
    private long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "tenant_id")
    private List<Reservation> reservations;

}
