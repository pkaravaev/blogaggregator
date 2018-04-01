package com.pkaravaev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomController {

    @RequestMapping("/welcome")
    public String welcome(){

        System.out.println("work!!!!");
        return "index";
    }
}
