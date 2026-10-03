package com.example.primer_spring_boot.service;


import org.springframework.stereotype.Service;

import com.example.primer_spring_boot.model.Videojuego;
import com.example.primer_spring_boot.repository.VideojuegoRepository;

import java.util.List;


@Service 
public class VideojuegoService {
    
    private VideojuegoRepository videojuegoRepository;

    public VideojuegoService(VideojuegoRepository videojuegoRepository){
        this.videojuegoRepository = videojuegoRepository;
    }

    public Videojuego registrarVideojuego(Videojuego videojuego){
        if (videojuego.getHours() < 0) {
            throw new IllegalArgumentException("Las horas no pueden ser negativas");
        }
        videojuegoRepository.registrarVideojuego(videojuego);
        return videojuego;
    }

    public List<Videojuego> mostrarVideojuegos(){
        return videojuegoRepository.mostrarVideojuegos();
    }

    public void eliminarVideojuego(long id){
        Boolean existe = videojuegoRepository.eliminarVideojuego(id);
        if (!existe) {
            throw new IllegalArgumentException("ID no existente");
        }
    }
}
