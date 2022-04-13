package com.cenfotec.examen.controller;

import com.cenfotec.examen.domain.Cliente;
import com.cenfotec.examen.domain.Trabajo;
import com.cenfotec.examen.service.ClienteService;
import com.cenfotec.examen.service.TrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TrabajoController {
    @Autowired
    TrabajoService trabajoService;
    @Autowired
    ClienteService clienteService;
    @RequestMapping(value = "/verTrabajos")
    public String navegarPaginaListaTrabajos(Model model){
        model.addAttribute("trabajo", trabajoService.GetAll());
        return "verTrabajos";
    }

    @RequestMapping(value = "/agregarTrabajo", method = RequestMethod.GET)
    public String navegarPaginaInsertarTrabajo(Model model){

        model.addAttribute(new Trabajo());
        model.addAttribute("cliente", clienteService.getAll());
        return "agregarTrabajo";
    }

    @RequestMapping(value = "/agregarTrabajo", method = RequestMethod.POST)
    public String accionPAginaAgregarTrabajo(Trabajo trabajo, BindingResult result, Model model){
        trabajoService.SaveTrabajo(trabajo);
        return "exito";
    }
}
