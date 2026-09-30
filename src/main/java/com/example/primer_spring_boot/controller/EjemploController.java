package com.example.primer_spring_boot.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class EjemploController {

    @GetMapping("/detalles_info")
    public HashMap<String,Object> holaSpring() {
        HashMap <String,Object> map = new HashMap<>();
        map.put("title","Spring Boot page");
        map.put("name","Tomas");
        map.put("message","hi :)");
        return map;
    }
    
}

