package com.example.shop.controllers;

import com.example.shop.entities.Customer;
import com.example.shop.entities.Employee;
import com.example.shop.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/action")
    public String chooseAction(Model model) {
        model.addAttribute("action");
        return "employee";
    }

    @PostMapping("/action")
    public String chooseAction(@RequestParam("action") String action) {
        if (action.equals("log in")) {
            return "redirect:/employee/log-in";
        } else {
            return "redirect:/employee/sign-up";
        }
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("employee", new Employee());
        return "sign-up-employee";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute("employee") Employee employee) {
        employeeRepository.save(employee);
        return " ";
    }
}
