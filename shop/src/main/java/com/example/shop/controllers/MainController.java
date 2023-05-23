package com.example.shop.controllers;

import com.example.shop.entities.Customer;
import com.example.shop.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/shop")
public class MainController {
    @GetMapping("/home")
    public String chooseRole(Model model) {
        model.addAttribute("role");
        return "home";
    }

    @PostMapping("/home")
    public String chooseRole(@RequestParam("role") String role) {
        if (role.equals("employee")) {
            return "redirect:/employee";
        } else {
            return "redirect:/customer";
        }
    }

    @GetMapping("/employee")
    public String signInEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "redirect:/employee/action";
    }

    @GetMapping("/customer")
    public String signInCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "redirect:/customer/action";
    }
}
