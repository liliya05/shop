package com.example.shop.controllers;

import com.example.shop.entities.Customer;
import com.example.shop.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/action")
    public String chooseAction(Model model) {
        model.addAttribute("action");
        return "customer";
    }

    @PostMapping("/action")
    public String chooseAction(@RequestParam("action") String action) {
        if (action.equals("log in")) {
            return "redirect:/customer/log-in";
        } else {
            return "redirect:/customer/sign-up";
        }
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("customer", new Customer());
        return "sign-up-customer";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute("admin") Customer customer) {
        customerRepository.save(customer);
        return " ";
    }
}
