package com.cenfotec.examen.controller;

import com.cenfotec.examen.domain.Consultor;
import com.cenfotec.examen.service.ConsultorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Controller
public class ConsultorController {

    @Autowired
    ConsultorService consultorService;

    @RequestMapping("/verConsultores")
    public String index(Model model){
        model.addAttribute("consultor", consultorService.getAll());
        return "verConsultores";
    }
    @RequestMapping(value = "/agregarConsultor", method = RequestMethod.GET)
    public String navegarPaginaConsultor(Model model){
        model.addAttribute(new Consultor());
        return "agregarConsultor";
    }

    @RequestMapping(value = "/agregarConsultor", method = RequestMethod.POST)
    public String accionInsertarConsultor(Consultor consultor, BindingResult result, Model model){
        consultor.setEstado(true);
        consultorService.saveConsultor(consultor);
        return "exito";
    }

    @RequestMapping(value = "/editarConsultor/{id}")
    public String irAEditar(Model model, @PathVariable int id) {
        Optional<Consultor> consultorToEdit = consultorService.getById(id);
        if (consultorToEdit.isPresent()){
            model.addAttribute("consultorToEdit", consultorToEdit);
            return "editConsultor";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editarConsultor/{id}", method = RequestMethod.POST)
    public String guardarCambios(Consultor consultor, BindingResult result,Model model, @PathVariable int id) {

        consultorService.updateConsultor(consultor);
        return "exito";
    }

    @RequestMapping(value = "/estadoConsultor/{id}", method = RequestMethod.POST)
    public String cambiarEstadoConsultor(Consultor consultor, BindingResult result,Model model, @PathVariable int id) {

        Optional<Consultor> consultorToEdit = consultorService.getById(id);

        if(consultorToEdit.get().isEstado() == true){
            consultorToEdit.get().setEstado(false);
        }else{
            consultorToEdit.get().setEstado(true);
        }
        consultorService.updateConsultor(consultorToEdit.get());

        System.out.println(consultorToEdit.get().isEstado());
        return "exito";
    }

}
