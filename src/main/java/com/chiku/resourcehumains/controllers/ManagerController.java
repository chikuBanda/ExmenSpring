package com.chiku.resourcehumains.controllers;

import com.chiku.resourcehumains.entities.DepAdminstratif;
import com.chiku.resourcehumains.entities.Manager;
import com.chiku.resourcehumains.exceptions.ResourceNotFoundException;
import com.chiku.resourcehumains.services.DepAdministratifService;
import com.chiku.resourcehumains.services.ManagerService;
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
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @Autowired
    DepAdministratifService depAdministratifService;

    @GetMapping(value = {"/manager/add"})
    public String addForm(Model model)
    {
        Manager manager = new Manager();
        model.addAttribute("manager", manager);
        model.addAttribute("deps", depAdministratifService.getDeps());

        return "employe/manager/add";
    }

    @PostMapping("/add_manager")
    public String addDepAdmin(@Valid @ModelAttribute("manager") Manager manager, BindingResult result, Model model){
        if(result.hasErrors()){
            return "employe/manager/add";
        }

        managerService.save(manager);
        return "redirect:/";
    }

    @GetMapping(value = {"/manager/{id}"})
    public String show(@PathVariable("id") long id, Model model) throws ResourceNotFoundException
    {
        model.addAttribute("manager", managerService.findById(id));
        return "employe/manager/show";
    }
}
