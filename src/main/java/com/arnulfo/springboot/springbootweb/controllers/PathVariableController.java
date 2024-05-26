package com.arnulfo.springboot.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arnulfo.springboot.springbootweb.models.dto.ParamsDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    // http://localhost:3000/api/var/baz/bar
    @GetMapping("/baz/{message}")
    public ParamsDTO pathParam(@PathVariable(required = false) String message) {
        var dto = new ParamsDTO();
        dto.setMessage(message);
        return dto;
    }

    @GetMapping("/foobar/{message}/{code}")
    public ParamsDTO pathParams(@PathVariable String message, @PathVariable Integer code) {
        var dto = new ParamsDTO();
        dto.setMessage(message);
        dto.setCode(code);
        return dto;
    }
}
