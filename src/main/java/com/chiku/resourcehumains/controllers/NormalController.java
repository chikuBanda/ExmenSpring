package com.chiku.resourcehumains.controllers;

import com.chiku.resourcehumains.entities.Manager;
import com.chiku.resourcehumains.entities.NormalEmp;
import com.chiku.resourcehumains.exceptions.ResourceNotFoundException;
import com.chiku.resourcehumains.services.DepAdministratifService;
import com.chiku.resourcehumains.services.DepServService;
import com.chiku.resourcehumains.services.ManagerService;
import com.chiku.resourcehumains.services.NormalEmpService;
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
public class NormalController {
    @Autowired
    NormalEmpService normalEmpService;

    @Autowired
    DepServService depServService;

    @Autowired
    ManagerService managerService;

    @GetMapping(value = {"/employe/add"})
    public String addForm(Model model)
    {
        NormalEmp normalEmp = new NormalEmp();
        model.addAttribute("normalEmp", normalEmp);
        model.addAttribute("deps", depServService.getDeps());
        model.addAttribute("managers", managerService.getManagers());

        return "employe/normal_emp/add";
    }

    @PostMapping("/add_employe")
    public String addDepAdmin(@Valid @ModelAttribute("normalEmp")NormalEmp normalEmp, BindingResult result, Model model){
        if(result.hasErrors()){
            return "employe/normal_emp/add";
        }

        normalEmpService.save(normalEmp);
        return "redirect:/";
    }

    @GetMapping(value = {"/employe/{id}"})
    public String show(@PathVariable("id") long id, Model model) throws ResourceNotFoundException
    {
        model.addAttribute("normalEmp", normalEmpService.findById(id));
        return "employe/normal_emp/show";
    }

    @GetMapping(value = {"/employe/modifier/{id}"})
    public String update(@PathVariable("id") long id, Model model) throws ResourceNotFoundException
    {
        model.addAttribute("normalEmp", normalEmpService.findById(id));
        model.addAttribute("deps", depServService.getDeps());
        model.addAttribute("managers", managerService.getManagers());
        return "employe/normal_emp/update";
    }

    @PostMapping("/modifier_employe")
    public String modifier(@Valid @ModelAttribute("normalEmp")NormalEmp normalEmp, BindingResult result, Model model){
        if(result.hasErrors()){
            return "employe/normal_emp/update";
        }

        normalEmpService.save(normalEmp);
        return "redirect:/employe/";
    }
}
