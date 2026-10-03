package com.example.primer_spring_boot.repository;

import org.springframework.stereotype.Repository;
import com.example.primer_spring_boot.model.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

@Repository 
public class VideojuegoRepository {
    long siguienteId = 1L;

    HashMap<Long,Videojuego> videojuegos = new HashMap<>();

    public List<Videojuego> mostrarVideojuegos() {
        return new ArrayList<>(videojuegos.values());
    }


    public Videojuego registrarVideojuego(Videojuego videojuego){
        videojuego.setId(siguienteId);
        videojuegos.put(videojuego.getId(), videojuego);
        siguienteId++;
        return videojuego;
    }


    public Boolean eliminarVideojuego(long id){
        for (Videojuego p : videojuegos.values()) {
            if (p.getId() == id) {
                videojuegos.remove(id);
                return true;
            }
        }
        return false;

    }
    
}
