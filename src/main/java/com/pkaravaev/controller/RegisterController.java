package com.pkaravaev.controller;


import com.pkaravaev.model.User;
import com.pkaravaev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;


    @ModelAttribute("user")
    public User contruct() {
        return new User();
    }

    @RequestMapping( method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") User user, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return "user-register";
        }
        userService.save(user);
        return "redirect:/register.html?success=true";
    }

    @RequestMapping
    public String showRegister() {
        return "user-register";
    }
}
