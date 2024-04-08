package com.example.f290_dsm_cambio_ms.domain.repositories;

import com.example.f290_dsm_cambio_ms.domain.entities.Euro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EuroRepository extends JpaRepository<Euro, Long> {
}
