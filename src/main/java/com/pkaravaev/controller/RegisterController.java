package com.pkaravaev.controller;


import com.pkaravaev.model.User;
import com.pkaravaev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String doRegister(@ModelAttribute("user") User user, @Valid BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "user-register";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/register.html";
    }

    @RequestMapping
    public String showRegister() {
        return "user-register";
    }

    @RequestMapping("/available")
    @ResponseBody
    public String available(@RequestParam String username) {
        Boolean available = userService.findOne(username) == null;
        return available.toString();
    }
}
