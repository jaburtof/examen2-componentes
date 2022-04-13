package com.cenfotec.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<com.cenfotec.examen.domain.Cliente, Long>{
    com.cenfotec.examen.domain.Cliente findClienteByRazonSocial(String razonSocial);
}
