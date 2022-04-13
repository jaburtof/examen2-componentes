package com.cenfotec.examen.repository;

import com.cenfotec.examen.domain.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajoRepository extends JpaRepository<Trabajo, Long> {
}
