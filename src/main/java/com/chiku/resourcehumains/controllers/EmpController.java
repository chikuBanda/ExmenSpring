package com.chiku.resourcehumains.controllers;

import com.chiku.resourcehumains.services.ManagerService;
import com.chiku.resourcehumains.services.NormalEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpController {
    @Autowired
    ManagerService managerService;

    @Autowired
    NormalEmpService normalEmpService;

    @GetMapping(value = {"/employe/"})
    public String home(Model model)
    {
        model.addAttribute("empsNormale", normalEmpService.getEmps());
        model.addAttribute("empsManager", managerService.getManagers());
        return "employe/home";
    }
}
