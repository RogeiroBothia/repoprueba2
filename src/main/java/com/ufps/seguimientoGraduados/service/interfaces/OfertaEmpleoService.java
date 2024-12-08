package com.ufps.seguimientoGraduados.service.interfaces;

import com.ufps.seguimientoGraduados.persistence.entity.OfertaEmpleo;

import java.util.List;
import java.util.Optional;

public interface OfertaEmpleoService {
    List<OfertaEmpleo> getAllActiveOfertas();

    List<OfertaEmpleo> getNoActiveOfertas();

    Optional<OfertaEmpleo> getOfertaById(Long id);
    void createOferta(OfertaEmpleo oferta);
    void updateOferta(Long id, OfertaEmpleo oferta);
    void deleteOfertaById(Long id);

    void addUserToOferta(Long ofertaId, Long userId);

    void activeOferta(Long OfertaId);
}
