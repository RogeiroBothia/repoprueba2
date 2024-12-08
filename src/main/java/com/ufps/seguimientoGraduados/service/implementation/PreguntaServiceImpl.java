package com.ufps.seguimientoGraduados.service.implementation;

import com.ufps.seguimientoGraduados.persistence.entity.Pregunta;
import com.ufps.seguimientoGraduados.persistence.repository.PreguntaRepository;
import com.ufps.seguimientoGraduados.service.interfaces.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreguntaServiceImpl implements PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;
    @Override
    public List<Pregunta> getAllPreguntas() {
        return preguntaRepository.findAll();
    }
    @Override
    public Optional<Pregunta> getPreguntaById(Long id) {
        return preguntaRepository.findById(id);
    }

    @Override public void createPregunta(Pregunta pregunta) {
        preguntaRepository.save(pregunta);
    }

    @Override public void updatePregunta(Long id, Pregunta pregunta) {
        Pregunta preguntaDB = preguntaRepository.findById(id) .orElseThrow(() -> new RuntimeException("Invalid pregunta id"));
        preguntaDB.setTitulo(pregunta.getTitulo());
        preguntaDB.setDescripcion(pregunta.getDescripcion());
        preguntaDB.setImagenUrl(pregunta.getImagenUrl());
        preguntaDB.setMasInfo(pregunta.getMasInfo());
        preguntaRepository.save(preguntaDB);
    }

    @Override public void deletePreguntaById(Long id) {
        preguntaRepository.deleteById(id);
    }
}
