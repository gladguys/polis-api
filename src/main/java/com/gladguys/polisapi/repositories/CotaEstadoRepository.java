package com.gladguys.polisapi.repositories;

import com.gladguys.polisapi.models.CotaEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotaEstadoRepository extends JpaRepository<CotaEstado, Long> {}
