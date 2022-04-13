package com.cenfotec.examen.controller;

import com.cenfotec.examen.domain.Persona;
import com.cenfotec.examen.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

import static java.lang.Long.valueOf;

@Controller
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @RequestMapping("/verPersonas/{id}")
    public String index(Model model,  @PathVariable int id){
        model.addAttribute("persona", personaService.getAllById(id));
        return "verPersonas";
    }
    @RequestMapping(value = "/agregarPersona/{id}", method = RequestMethod.GET)
    public String navegarPaginaPersona(Model model, @PathVariable int id ){
        Persona persona = new Persona();
        persona.setClienteReferencia(valueOf(id));
        model.addAttribute(persona);
        return "agregarPersona";
    }

    @RequestMapping(value = "/agregarPersona", method = RequestMethod.POST)
    public String accionInsertarPersona(Persona persona, BindingResult result, Model model){
        personaService.savePersona(persona);
        return "exito";
    }

    @RequestMapping(value = "/editarPersona/{id}")
    public String irAEditar(Model model, @PathVariable int id) {
        Optional<Persona> personaToEdit = personaService.getById(id);
        if (personaToEdit.isPresent()){
            model.addAttribute("personaToEdit", personaToEdit);
            return "editPersona";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editarPersona/{id}", method = RequestMethod.POST)
    public String guardarCambios(Persona persona, BindingResult result,Model model, @PathVariable int id) {
        personaService.updatePersona(persona);
        return "exito";
    }

    @RequestMapping(value = "/borrarPersona/{id}")
    public String borrar(Model model, @PathVariable int id) {
        personaService.deletePersona(id);
        return "exito";
    }

}
