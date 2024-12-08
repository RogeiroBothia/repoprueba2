package com.ufps.seguimientoGraduados.presentation.controller;

import com.ufps.seguimientoGraduados.persistence.entity.OfertaEmpleo;
import com.ufps.seguimientoGraduados.service.interfaces.OfertaEmpleoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class OfertaEmpleoController {
    @Autowired
    private OfertaEmpleoService ofertaEmpleoService;

    @GetMapping("/allActive")
    public List<OfertaEmpleo> getAllActiveOfertas() {
        return ofertaEmpleoService.getAllActiveOfertas();
    }

    //funciona
    @GetMapping("/{ofertaId}")
    public OfertaEmpleo getOfertaById(@PathVariable Long ofertaId) {
        return ofertaEmpleoService.getOfertaById(ofertaId) .orElseThrow(() -> new RuntimeException("Invalid oferta id"));
    }

    //funciona
    @PostMapping("/create")
    public ResponseEntity<String> createOferta(@RequestBody OfertaEmpleo oferta) {
        ofertaEmpleoService.createOferta(oferta);
        return ResponseEntity.status(HttpStatus.CREATED).body("Oferta creada exitosamente");
    }

    //funciona
    @PutMapping("/{ofertaId}/update")
    public ResponseEntity<String> updateOferta(@PathVariable Long ofertaId, @RequestBody OfertaEmpleo oferta) {
        ofertaEmpleoService.updateOferta(ofertaId, oferta);
        return ResponseEntity.status(HttpStatus.OK).body("Oferta actualizada exitosamente");
    }


    @DeleteMapping("/{ofertaId}/delete")
    public ResponseEntity<String> deleteOferta(@PathVariable Long ofertaId) {
        ofertaEmpleoService.deleteOfertaById(ofertaId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Oferta eliminada exitosamente");
    }

    //funciona
    @PostMapping("/{ofertaId}/addUser/{userId}")
    public ResponseEntity<String> addUserToOferta(@PathVariable Long ofertaId, @PathVariable Long userId) {
        ofertaEmpleoService.addUserToOferta(ofertaId, userId);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario registrado en la oferta exitosamente"); }
}
