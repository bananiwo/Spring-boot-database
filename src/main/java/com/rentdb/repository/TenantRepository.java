package com.rentdb.repository;

import com.rentdb.model.Reservation;
import com.rentdb.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

    @Query("SELECT r FROM Reservation r JOIN Tenant t ON r.tenantId=t.id WHERE t.name=?1")
    List<Reservation> findReservationByTenantName(String tenantName);
}
