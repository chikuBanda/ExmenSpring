package com.chiku.resourcehumains.controllers;

import com.chiku.resourcehumains.entities.DepAdminstratif;
import com.chiku.resourcehumains.entities.DepService;
import com.chiku.resourcehumains.exceptions.ResourceNotFoundException;
import com.chiku.resourcehumains.services.DepAdministratifService;
import com.chiku.resourcehumains.services.DepServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DepServiceController {
    @Autowired
    DepServService depServService;

    @GetMapping(value = {"/departement/service/add"})
    public String addForm(Model model)
    {
        DepService depService = new DepService();
        model.addAttribute("depService", depService);

        return "departement/service/add";
    }

    @PostMapping("/add_depservice")
    public String addDepAdmin(@Valid @ModelAttribute("depService") DepService depService, BindingResult result, Model model){
        if(result.hasErrors()){
            return "departement/service/add";
        }

        depServService.save(depService);
        return "redirect:/";
    }

    @GetMapping(value = {"/departement/service/{id}"})
    public String show(@PathVariable("id") long id, Model model) throws ResourceNotFoundException
    {
        model.addAttribute("dep", depServService.findById(id));
        return "departement/service/show";
    }

    @GetMapping(value = {"/departement/service/modifier/{id}"})
    public String update(@PathVariable("id") long id, Model model) throws ResourceNotFoundException
    {
        model.addAttribute("depService", depServService.findById(id));

        return "departement/service/update";
    }

    @PostMapping("/modifier_depservice")
    public String modifier(@Valid @ModelAttribute("depService") DepService depService, BindingResult result, Model model){
        if(result.hasErrors()){
            return "departement/service/update";
        }

        depServService.save(depService);
        return "redirect:/";
    }

    @GetMapping(value = {"/departement/service/delete/{id}"})
    public String delete(@PathVariable("id") long id) throws ResourceNotFoundException
    {
        depServService.deleteById(id);
        return "redirect:/";
    }

}
