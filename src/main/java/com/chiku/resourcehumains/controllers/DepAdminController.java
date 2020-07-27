package com.chiku.resourcehumains.controllers;

import com.chiku.resourcehumains.entities.DepAdminstratif;
import com.chiku.resourcehumains.exceptions.ResourceNotFoundException;
import com.chiku.resourcehumains.services.DepAdministratifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class DepAdminController {

    @Autowired
    DepAdministratifService depAdministratifService;

    @GetMapping(value = {"/departement/administratif/add"})
    public String addForm(Model model)
    {
        DepAdminstratif depAdminstratif = new DepAdminstratif();
        model.addAttribute("depAdminstratif", depAdminstratif);
        model.addAttribute("navDepActive", "active");

        return "departement/administratif/add";
    }

    @PostMapping("/add_depadmin")
    public String addDepAdmin(@Valid @ModelAttribute("depAdminstratif") DepAdminstratif depAdminstratif, BindingResult result, Model model){
        if(result.hasErrors()){
            return "departement/administratif/add";
        }

        depAdministratifService.save(depAdminstratif);
        return "redirect:/";
    }

    @GetMapping(value = {"/departement/administratif/modifier/{id}"})
    public String update(@PathVariable("id") long id, Model model) throws ResourceNotFoundException
    {
        model.addAttribute("depAdminstratif", depAdministratifService.findById(id));
        model.addAttribute("navDepActive", "active");

        return "departement/administratif/update";
    }

    @PostMapping("/modifier_depadmin")
    public String modifier(@Valid @ModelAttribute("depAdminstratif") DepAdminstratif depAdminstratif, BindingResult result, Model model){
        if(result.hasErrors()){
            return "departement/administratif/update";
        }

        depAdministratifService.save(depAdminstratif);
        return "redirect:/";
    }

    @GetMapping(value = {"/departement/administratif/{id}"})
    public String show(@PathVariable("id") long id, Model model) throws ResourceNotFoundException
    {
        model.addAttribute("dep", depAdministratifService.findById(id));
        model.addAttribute("navDepActive", "active");

        return "departement/administratif/show";
    }

    @GetMapping(value = {"/departement/administratif/delete/{id}"})
    public String delete(@PathVariable("id") long id) throws ResourceNotFoundException
    {
        depAdministratifService.deleteById(id);
        return "redirect:/departement/";
    }

}
