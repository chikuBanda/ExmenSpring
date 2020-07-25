package com.chiku.resourcehumains.controllers;

import com.chiku.resourcehumains.entities.DepAdminstratif;
import com.chiku.resourcehumains.services.DepAdministratifService;
import com.chiku.resourcehumains.services.DepServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DepController {
    @Autowired
    DepAdministratifService depAdministratifService;

    @Autowired
    DepServService depServService;

    @GetMapping(value = {"/", "/departement/"})
    public String home(Model model)
    {
        model.addAttribute("depsAdmin", depAdministratifService.getDeps());
        model.addAttribute("depsServ", depServService.getDeps());
        return "departement/home";
    }
}
