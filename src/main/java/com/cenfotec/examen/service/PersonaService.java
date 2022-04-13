package com.cenfotec.examen.service;

import com.cenfotec.examen.domain.Persona;
import com.cenfotec.examen.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public void savePersona(Persona consultor){
        personaRepository.save(consultor);
    }

    public List<Persona> getAll(){
        return personaRepository.findAll();
    }

    public List<Persona> getAllById(int id){

        List<Persona> personas = new ArrayList<Persona>();
        for(Persona persona : personaRepository.findAll()) {
            if(persona.getClienteReferencia() == Long.valueOf(id)){
                personas.add(persona);
            }
        }
        return personas;
    }

    public Optional<Persona> getById(int id) {return personaRepository.findById(Long.valueOf(id));}

    public void updatePersona(Persona persona) {
        personaRepository.save(persona);
    }

    public void deletePersona(int id) {
        personaRepository.deleteById(Long.valueOf(id));
    }
}
