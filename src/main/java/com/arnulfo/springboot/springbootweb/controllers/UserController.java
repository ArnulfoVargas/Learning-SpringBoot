package com.arnulfo.springboot.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.arnulfo.springboot.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details") // We can also use @RequestMapping(path="/details", method=RequestMethod.GET)
    public String details(Model model) {
        User user = new User("Arnulfo", "Vargas");

        model.addAttribute("title", "Details");
        model.addAttribute("content", "Hello world from springboot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list_users")
    public String listUsers(ModelMap model) {
        // model.addAttribute("users", listUsers);
        model.addAttribute("title", "Lista");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        var user1 = new User("Arnulfo", "Vargas");
        var user2 = new User("Betsa", "Salazar");
        var user3 = new User("Fernando", "Patino");

        return Arrays.asList(user1, user2, user3);
    }
}
