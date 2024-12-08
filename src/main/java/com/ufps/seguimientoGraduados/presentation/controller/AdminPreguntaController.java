package com.ufps.seguimientoGraduados.presentation.controller;

import com.ufps.seguimientoGraduados.persistence.entity.Pregunta;
import com.ufps.seguimientoGraduados.service.interfaces.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/pregunta")
public class AdminPreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @GetMapping("/{preguntaId}")
    public Pregunta getPreguntaById(@PathVariable Long preguntaId) {
        return preguntaService.getPreguntaById(preguntaId) .orElseThrow(() -> new RuntimeException("Invalid pregunta id"));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPregunta(@RequestBody Pregunta pregunta) {
        preguntaService.createPregunta(pregunta);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pregunta creada exitosamente");
    }

    @PutMapping("/{preguntaId}/update")
    public ResponseEntity<String> updatePregunta(@PathVariable Long preguntaId, @RequestBody Pregunta pregunta) {
        preguntaService.updatePregunta(preguntaId, pregunta);
        return ResponseEntity.status(HttpStatus.OK).body("Pregunta actualizada exitosamente");
    }

    @DeleteMapping("/{preguntaId}/delete")
    public ResponseEntity<String> deletePregunta(@PathVariable Long preguntaId) {
        preguntaService.deletePreguntaById(preguntaId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Pregunta eliminada exitosamente"); }
}
