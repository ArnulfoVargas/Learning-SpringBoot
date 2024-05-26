package com.arnulfo.springboot.springbootweb.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arnulfo.springboot.springbootweb.models.User;
import com.arnulfo.springboot.springbootweb.models.dto.UserDTO;

@RestController // I can also use Controller but i need to also declare my methods as Response
                // body
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details_map")
    // @ResponseBody
    public Map<String, Object> DetailsMap() {
        User user = new User("Arnulfo", "Vargas");
        Map<String, Object> response = new HashMap<>();
        response.put("title", "User");
        response.put("user", user);

        return response;
    }

    @GetMapping("/list_users")
    public List<User> listUsers() {
        var user1 = new User("Arnulfo", "Vargas");
        var user2 = new User("Betsa", "Salazar");
        var user3 = new User("Fernando", "Patino");

        List<User> listUsers = Arrays.asList(user1, user2, user3);
        return listUsers;
    }

    @GetMapping("/details")
    public UserDTO details() {
        UserDTO user = new UserDTO("UserDto", new User("Arnulfo", "Vargas"));
        return user;
    }
}
