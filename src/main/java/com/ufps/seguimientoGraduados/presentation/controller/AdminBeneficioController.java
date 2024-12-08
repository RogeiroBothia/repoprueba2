package com.ufps.seguimientoGraduados.presentation.controller;

import com.ufps.seguimientoGraduados.persistence.entity.Beneficio;
import com.ufps.seguimientoGraduados.service.interfaces.BeneficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/beneficio")
public class AdminBeneficioController {

    @Autowired
    private BeneficioService beneficioService;

    @GetMapping("/{beneficioId}")
    public Beneficio getBeneficioById(@PathVariable Long beneficioId) {
        return beneficioService.getBeneficioById(beneficioId) .orElseThrow(() -> new RuntimeException("Invalid beneficio id"));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createBeneficio(@RequestBody Beneficio beneficio) {
        beneficioService.createBeneficio(beneficio);
        return ResponseEntity.status(HttpStatus.CREATED).body("Beneficio creado exitosamente");
    }

    @PutMapping("/{beneficioId}/update")
    public ResponseEntity<String> updateBeneficio(@PathVariable Long beneficioId, @RequestBody Beneficio beneficio) {
        beneficioService.updateBeneficio(beneficioId, beneficio);
        return ResponseEntity.status(HttpStatus.OK).body("Beneficio actualizado exitosamente");
    }

    @DeleteMapping("/{beneficioId}/delete")
    public ResponseEntity<String> deleteBeneficio(@PathVariable Long beneficioId) {
        beneficioService.deleteBeneficioById(beneficioId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Beneficio eliminado exitosamente"); }
}
