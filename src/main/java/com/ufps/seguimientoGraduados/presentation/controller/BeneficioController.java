package com.ufps.seguimientoGraduados.presentation.controller;

import com.ufps.seguimientoGraduados.persistence.entity.Beneficio;
import com.ufps.seguimientoGraduados.service.interfaces.BeneficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/beneficios")
public class BeneficioController {

    @Autowired
    private BeneficioService beneficioService;

    @GetMapping()
    public List<Beneficio> getAllBeneficios() {
        return beneficioService.getAllBeneficios();
    }
}
