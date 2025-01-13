package com.mfigueroa.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api")
public class MovieController {


    // Retornamos todo el indice
    @GetMapping()
    public String index() {
        return "index";
    }

}
