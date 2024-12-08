package com.ufps.seguimientoGraduados.service.interfaces;

import com.ufps.seguimientoGraduados.persistence.entity.Pregunta;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {
    List<Pregunta> getAllPreguntas();
    Optional<Pregunta> getPreguntaById(Long id);
    void createPregunta(Pregunta pregunta);
    void updatePregunta(Long id, Pregunta pregunta);
    void deletePreguntaById(Long id);
}
