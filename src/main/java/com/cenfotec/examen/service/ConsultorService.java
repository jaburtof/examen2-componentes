package com.cenfotec.examen.service;

import com.cenfotec.examen.domain.Consultor;
import com.cenfotec.examen.repository.ConsultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultorService {

    @Autowired
    ConsultorRepository consultorRepository;

    public void saveConsultor(com.cenfotec.examen.domain.Consultor consultor){
        consultorRepository.save(consultor);
    }

    public List<com.cenfotec.examen.domain.Consultor> getAll(){
        return consultorRepository.findAll();
    }

    public Optional<Consultor> getById(int id) {
        return consultorRepository.findById(Long.valueOf(id));
    }

    public void updateConsultor(Consultor consultor) {
        consultorRepository.save(consultor);
    }

    public void deleteConsultor(int id) {
        consultorRepository.deleteById(Long.valueOf(id));
    }
}
