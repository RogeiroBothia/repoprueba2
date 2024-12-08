package com.ufps.seguimientoGraduados.persistence.repository;

import com.ufps.seguimientoGraduados.persistence.entity.OfertaEmpleo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfertaEmpleoRepository extends JpaRepository<OfertaEmpleo,Long> {
    List<OfertaEmpleo> findByActiveOfertaTrue();
    List<OfertaEmpleo> findByActiveOfertaFalse();
}
