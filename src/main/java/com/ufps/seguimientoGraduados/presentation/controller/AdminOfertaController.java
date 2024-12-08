package com.ufps.seguimientoGraduados.presentation.controller;

import com.ufps.seguimientoGraduados.persistence.entity.OfertaEmpleo;
import com.ufps.seguimientoGraduados.service.interfaces.OfertaEmpleoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/job")
public class AdminOfertaController {

    @Autowired
    private OfertaEmpleoService ofertaService;

    //Funciona
    @GetMapping()
    public List<OfertaEmpleo> postNoActivated(){
        return ofertaService.getNoActiveOfertas();
    }

    //Funciona
    @PutMapping("/{ofertaId}")
    public ResponseEntity<String> activarPost(@PathVariable Long ofertaId){
        ofertaService.activeOferta(ofertaId);
        return ResponseEntity.status(HttpStatus.OK).body("1");
    }
}
