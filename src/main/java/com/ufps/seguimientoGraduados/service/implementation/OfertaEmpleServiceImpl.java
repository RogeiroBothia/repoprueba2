package com.ufps.seguimientoGraduados.service.implementation;

import com.ufps.seguimientoGraduados.persistence.entity.OfertaEmpleo;
import com.ufps.seguimientoGraduados.persistence.entity.UserApp;
import com.ufps.seguimientoGraduados.persistence.repository.OfertaEmpleoRepository;
import com.ufps.seguimientoGraduados.persistence.repository.UserRepository;
import com.ufps.seguimientoGraduados.service.interfaces.OfertaEmpleoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OfertaEmpleServiceImpl implements OfertaEmpleoService {
    @Autowired
    private OfertaEmpleoRepository ofertaEmpleoRepository;

    @Autowired
    private UserRepository userRepository;

    @Override public List<OfertaEmpleo> getAllActiveOfertas() {
        return ofertaEmpleoRepository.findByActiveOfertaTrue();
    }

    @Override
    public List<OfertaEmpleo> getNoActiveOfertas() {
        return ofertaEmpleoRepository.findByActiveOfertaFalse();
    }

    @Override public Optional<OfertaEmpleo> getOfertaById(Long id) {
        return ofertaEmpleoRepository.findById(id);
    }

    @Override public void createOferta(OfertaEmpleo oferta) {
        oferta.setCreatedAt(LocalDateTime.now());
        oferta.setActiveOferta(false);
        ofertaEmpleoRepository.save(oferta);
    }

    @Override public void updateOferta(Long id, OfertaEmpleo oferta) {
        OfertaEmpleo ofertaDB = getOfertaById(id).orElseThrow(() -> new RuntimeException("Invalid oferta id"));
        ofertaDB.setTitulo(oferta.getTitulo());
        ofertaDB.setDescripcion(oferta.getDescripcion());
        ofertaDB.setImageUrl(oferta.getImageUrl());
        ofertaDB.setContacto(oferta.getContacto());
        ofertaEmpleoRepository.save(ofertaDB);
    }

    @Override public void deleteOfertaById(Long id) {
        ofertaEmpleoRepository.deleteById(id);
    }

    @Override
    public void addUserToOferta(Long ofertaId, Long userId) {
        OfertaEmpleo oferta = ofertaEmpleoRepository.findById(ofertaId) .orElseThrow(() -> new RuntimeException("Invalid oferta id"));
        UserApp user = userRepository.findById(userId) .orElseThrow(() -> new RuntimeException("Invalid user id"));
        oferta.getUserList().add(user);
        ofertaEmpleoRepository.save(oferta);
    }

    @Override
    public void activeOferta(Long OfertaId){
        OfertaEmpleo ofertaDB = getOfertaById(OfertaId).orElseThrow(() -> new RuntimeException("Invalid oferta id"));
        ofertaDB.setActiveOferta(true);
        ofertaEmpleoRepository.save(ofertaDB);
    }
}
