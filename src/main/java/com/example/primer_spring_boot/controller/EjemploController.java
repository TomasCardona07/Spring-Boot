package com.example.primer_spring_boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api")
public class EjemploController {

    @GetMapping("/hola")
    public String saludar(){
        return "Hola :)";
    }

    @GetMapping("/adios")
    public String despedir(){
        return "Adios :)";
    }

    @GetMapping("/nombre")
    public String nombre(){
        return "Tomi :)";
    }
}

