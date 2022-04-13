package com.cenfotec.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<com.cenfotec.examen.domain.Persona, Long>{
    com.cenfotec.examen.domain.Persona findPersonaByClienteReferencia(String clienteReferencia);
}
