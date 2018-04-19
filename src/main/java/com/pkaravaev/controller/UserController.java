package com.pkaravaev.controller;


import com.pkaravaev.model.Blog;
import com.pkaravaev.model.User;
import com.pkaravaev.repository.UserRepository;
import com.pkaravaev.service.BlogService;
import com.pkaravaev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;


    @ModelAttribute("user")
    public User contruct() {

        return new User();
    }

    @ModelAttribute("blog")
    public Blog contructBlog() {

        return new Blog();
    }

    @RequestMapping("/blog/remove/{id}")
    public String removeBlog(@PathVariable int id) {
        Blog blog = blogService.findOne(id);
        blogService.delete(blog);
        return "redirect:/account.html";
    }


//    @RequestMapping(value = "/account", method = RequestMethod.POST)
//    public String doAddBlog(Model model,
//                            @Valid @ModelAttribute("blog") Blog blog, BindingResult result,
//                            Principal principal) {
//        if (result.hasErrors()) {
//            return account(model, principal);
//        }
//        String name = principal.getName();
//        blogService.save(blog, name);
//        return "redirect:/account.html";
//    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/register.html?success=true";
    }

    @RequestMapping("/register")
    public String showRegister() {
        return "user-register";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping("/users/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.findOneWithBlogs(id));
        return "user-detail";
    }


    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal) {
        String name = principal.getName();
        blogService.save(blog, name);
        return "redirect:/account.html";
    }

    @RequestMapping("/account")
    public String account(Model model, Principal principal) {
        String name = principal.getName();
        model.addAttribute("user", userService.findOneWithBlogs(name));
        return "user-detail";
    }

}
