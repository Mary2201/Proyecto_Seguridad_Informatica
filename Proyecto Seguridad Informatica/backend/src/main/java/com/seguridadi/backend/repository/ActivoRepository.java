package com.seguridadi.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seguridadi.backend.model.Activo;
@Repository
public interface ActivoRepository extends JpaRepository<Activo, Long> {
}
