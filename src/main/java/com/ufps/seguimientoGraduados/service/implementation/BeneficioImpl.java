package com.ufps.seguimientoGraduados.service.implementation;

import com.ufps.seguimientoGraduados.persistence.entity.Beneficio;
import com.ufps.seguimientoGraduados.persistence.repository.BeneficioRepository;
import com.ufps.seguimientoGraduados.service.interfaces.BeneficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficioImpl implements BeneficioService {

    @Autowired private BeneficioRepository beneficioRepository;

    @Override
    public List<Beneficio> getAllBeneficios() {
        return beneficioRepository.findAll();
    }

    @Override public Optional<Beneficio> getBeneficioById(Long id) {
        return beneficioRepository.findById(id);
    }

    @Override public void createBeneficio(Beneficio beneficio) {
        beneficioRepository.save(beneficio);
    }

    @Override public void updateBeneficio(Long id, Beneficio beneficio) {
        Beneficio beneficioDB = beneficioRepository.findById(id) .orElseThrow(() -> new RuntimeException("Invalid beneficio id"));
        beneficioDB.setTitulo(beneficio.getTitulo());
        beneficioDB.setDescripcion(beneficio.getDescripcion());
        beneficioDB.setImagen(beneficio.getImagen());
        beneficioDB.setMasInfo(beneficio.getMasInfo());
        beneficioRepository.save(beneficioDB);
    }

    @Override
    public void deleteBeneficioById(Long id) { beneficioRepository.deleteById(id); }
}
