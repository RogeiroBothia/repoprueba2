package com.ufps.seguimientoGraduados.service.interfaces;

import com.ufps.seguimientoGraduados.persistence.entity.Beneficio;

import java.util.List;
import java.util.Optional;

public interface BeneficioService{
    List<Beneficio> getAllBeneficios();
    Optional<Beneficio> getBeneficioById(Long id);
    void createBeneficio(Beneficio beneficio);
    void updateBeneficio(Long id, Beneficio beneficio);
    void deleteBeneficioById(Long id);
}
