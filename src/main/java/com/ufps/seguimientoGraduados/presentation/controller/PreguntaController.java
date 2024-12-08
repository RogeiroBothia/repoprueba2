package com.ufps.seguimientoGraduados.presentation.controller;

import com.ufps.seguimientoGraduados.persistence.entity.Pregunta;
import com.ufps.seguimientoGraduados.service.interfaces.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {
    @Autowired
    private PreguntaService preguntaService;

    @GetMapping()
    public List<Pregunta> getAllPreguntas() {
        return preguntaService.getAllPreguntas();
    }
}
