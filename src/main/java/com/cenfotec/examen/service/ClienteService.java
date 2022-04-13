package com.cenfotec.examen.service;

import com.cenfotec.examen.domain.Cliente;
import com.cenfotec.examen.domain.Persona;
import com.cenfotec.examen.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void saveCliente(com.cenfotec.examen.domain.Cliente cliente){
        clienteRepository.save(cliente);
    }

    public List<com.cenfotec.examen.domain.Cliente> getAll(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getById(int id) {return clienteRepository.findById(Long.valueOf(id));}

    public void updateCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deleteCliente(int id) {
        clienteRepository.deleteById(Long.valueOf(id));
    }

}
