package com.example.f290_dsm_cambio_ms.domain.repositories;

import com.example.f290_dsm_cambio_ms.domain.entities.Dollar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DollarRepository extends JpaRepository<Dollar, Long> {

    @Query("SELECT d FROM dolar d ORDER BY d.id DESC LIMIT 1")
    Dollar getLast();
}
