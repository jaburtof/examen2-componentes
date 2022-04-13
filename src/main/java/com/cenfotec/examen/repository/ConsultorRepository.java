package com.cenfotec.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultorRepository extends JpaRepository<com.cenfotec.examen.domain.Consultor, Long>{
    com.cenfotec.examen.domain.Consultor findConsultorByNombre(String nombre);
}
