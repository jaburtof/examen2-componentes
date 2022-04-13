package com.cenfotec.examen.service;

import com.cenfotec.examen.domain.Trabajo;
import com.cenfotec.examen.repository.TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajoService {
    @Autowired
    TrabajoRepository trabajoRepository;

    public void SaveTrabajo(Trabajo trabajo){
        trabajoRepository.save(trabajo);
    }

    public List<Trabajo> GetAll(){
        return trabajoRepository.findAll();
    }
}
