package com.dsc.aeroparker_coding_challenge.controller;

import com.dsc.aeroparker_coding_challenge.model.User;
import com.dsc.aeroparker_coding_challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.SizeLimitExceededException;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String greetingForm(Model model) {
        model.addAttribute("registeredUser", new User());
        return "form";
    }

    @PostMapping("/registration")
    public String greetingSubmit(@ModelAttribute User user, Model model) throws SizeLimitExceededException {
        model.addAttribute("registeredUser", user);
        try{
        userService.saveUser(user);
        return "success";
       } catch (Exception e) {
                model.addAttribute("exceptionMessage", e.getMessage());
                return "form";
       }
    }
}
