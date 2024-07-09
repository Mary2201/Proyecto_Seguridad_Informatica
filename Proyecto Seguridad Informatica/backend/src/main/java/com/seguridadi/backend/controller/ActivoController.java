package com.seguridadi.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.seguridadi.backend.model.Activo;
import com.seguridadi.backend.service.ActivoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activos")
public class ActivoController {

    @Autowired
    private ActivoService activoService;

    @GetMapping("/findall")
    public List<Activo> listarActivos() {
        return activoService.obtenerActivos();
    }

    @GetMapping("/{id}")
    public Optional<Activo> obtenerActivoPorId(@PathVariable Long id) {
        return activoService.obtenerActivoPorId(id);
    }

    @PostMapping("/add")
    public Activo crearActivo(@RequestBody Activo activo) {
        return activoService.crearActivo(activo);
    }

    @PutMapping("/update/{id}")
    public Activo actualizarActivo(@PathVariable Long id, @RequestBody Activo activo) {
        return activoService.actualizarActivo(id, activo);
    }

    @DeleteMapping("/deletebyid/{id}")
    public void eliminarActivo(@PathVariable Long id) {
        activoService.eliminarActivo(id);
    }
}
