package com.seguridadi.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seguridadi.backend.model.Activo;
import com.seguridadi.backend.repository.ActivoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ActivoService {

    @Autowired
    private ActivoRepository activoRepository;

    public List<Activo> obtenerActivos() {
        return activoRepository.findAll();
    }

    public Optional<Activo> obtenerActivoPorId(Long id) {
        return activoRepository.findById(id);
    }

    public Activo crearActivo(Activo activo) {
        return activoRepository.save(activo);
    }

    public Activo actualizarActivo(Long id, Activo activo) {
        if (activoRepository.existsById(id)) {
            activo.setId(id);
            return activoRepository.save(activo);
        }
        return null;
    }

    public void eliminarActivo(Long id) {
        activoRepository.deleteById(id);
    }
}
