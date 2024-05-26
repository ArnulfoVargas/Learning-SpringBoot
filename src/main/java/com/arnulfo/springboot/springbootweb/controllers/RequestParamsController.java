package com.arnulfo.springboot.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arnulfo.springboot.springbootweb.models.dto.ParamsDTO;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    // Query params
    // http://127.0.0.1:3000/api/params/foo?message=hello%20World
    @GetMapping("/foo")
    public ParamsDTO foo(@RequestParam(required = false) String message) {
        var dto = new ParamsDTO();
        dto.setMessage(message != null ? message : "Hello world");
        return dto;
    }

    // http://127.0.0.1:3000/api/params/bar?text=hello%20World&code=10
    @GetMapping("/bar")
    public ParamsDTO bar(@RequestParam String text, @RequestParam Integer code) {
        var dto = new ParamsDTO();
        dto.setMessage(text);
        dto.setCode(code);
        return dto;
    }

    // http://localhost:3000/api/params/req?message=Hello%20World&code=10
    // This method is more manageable
    @GetMapping("/req")
    public ParamsDTO reqDto(HttpServletRequest req) {
        var code = 0;

        try {
            code = Integer.parseInt(req.getParameter("code"));
        } catch (NumberFormatException e) {}

        var dto = new ParamsDTO();
        dto.setMessage(req.getParameter("message"));
        dto.setCode(code);
        return dto;
    }

}