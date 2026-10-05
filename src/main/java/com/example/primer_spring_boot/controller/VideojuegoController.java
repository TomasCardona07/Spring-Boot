package com.example.primer_spring_boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;


import com.example.primer_spring_boot.model.*;
import com.example.primer_spring_boot.service.VideojuegoService;




@RestController 
@RequestMapping("https://tomascardona07.github.io/Spring-Boot")
public class VideojuegoController {

    private VideojuegoService videojuegoService;

    public VideojuegoController(VideojuegoService videojuegoService){
        this.videojuegoService = videojuegoService;
    }

    @GetMapping()
    public List<Videojuego> mostrarVideojuegos() {
        return videojuegoService.mostrarVideojuegos();
    }
    

    @PostMapping
    public ResponseEntity<?> agregarVideojuego(@RequestBody Videojuego videojuego) {
        try {
            Videojuego videojuegoGuardado = videojuegoService.registrarVideojuego(videojuego);
            return ResponseEntity.ok(videojuegoGuardado); //HTTP 200 OK
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); //HTTP 400 excepcion en services
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVideojuego(@PathVariable  long id){
        try {
            videojuegoService.eliminarVideojuego(id);
            return ResponseEntity.ok("Videojuego eliminado");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }
}

