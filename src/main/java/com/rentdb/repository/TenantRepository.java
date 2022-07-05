package com.rentdb.repository;

import com.rentdb.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

    @Query("Select t from Tenant t" + " left join fetch t.reservations")
    List<Tenant> findAllTenants();
}
