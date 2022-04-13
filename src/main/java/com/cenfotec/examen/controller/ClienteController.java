package com.cenfotec.examen.controller;

import com.cenfotec.examen.domain.Cliente;
import com.cenfotec.examen.domain.Consultor;
import com.cenfotec.examen.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;


@Controller
public class ClienteController {

    @Autowired
    ClienteService ClienteService;

    @RequestMapping("/verClientes")
    public String index(Model model){
        model.addAttribute("cliente", ClienteService.getAll());
        return "verClientes";
    }
    @RequestMapping(value = "/agregarCliente", method = RequestMethod.GET)
    public String navegarPaginaCliente(Model model){
        model.addAttribute(new Cliente());
        return "agregarCliente";
    }

    @RequestMapping(value = "/agregarCliente", method = RequestMethod.POST)
    public String accionInsertarCliente(Cliente cliente, BindingResult result, Model model){
        ClienteService.saveCliente(cliente);
        return "exito";
    }
    @RequestMapping(value = "/editarCliente/{id}")
    public String irAEditar(Model model, @PathVariable int id) {
        Optional<Cliente> clienteToEdit = ClienteService.getById(id);
        if (clienteToEdit.isPresent()){
            model.addAttribute("clienteToEdit", clienteToEdit);
            return "editCliente";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editarCliente/{id}", method = RequestMethod.POST)
    public String guardarCambios(Cliente cliente, BindingResult result,Model model, @PathVariable int id) {
        ClienteService.updateCliente(cliente);
        return "exito";
    }
}
