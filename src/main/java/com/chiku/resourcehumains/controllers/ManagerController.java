package com.chiku.resourcehumains.controllers;

import com.chiku.resourcehumains.entities.DepAdminstratif;
import com.chiku.resourcehumains.entities.Manager;
import com.chiku.resourcehumains.entities.NormalEmp;
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
        model.addAttribute("navEmpActive", "active");

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
        model.addAttribute("navEmpActive", "active");

        return "employe/manager/show";
    }

    @GetMapping(value = {"/manager/modifier/{id}"})
    public String update(@PathVariable("id") long id, Model model) throws ResourceNotFoundException
    {
        model.addAttribute("manager", managerService.findById(id));
        model.addAttribute("deps", depAdministratifService.getDeps());
        model.addAttribute("navEmpActive", "active");

        return "employe/manager/update";
    }

    @PostMapping("/modifier_manager")
    public String modifier(@Valid @ModelAttribute("manager") Manager manager, BindingResult result, Model model){
        if(result.hasErrors()){
            return "employe/manager/update";
        }

        managerService.save(manager);
        return "redirect:/employe/";
    }

    @GetMapping(value = {"/manager/delete/{id}"})
    public String delete(@PathVariable("id") long id) throws ResourceNotFoundException
    {
        managerService.deleteById(id);
        return "redirect:/employe/";
    }
}
