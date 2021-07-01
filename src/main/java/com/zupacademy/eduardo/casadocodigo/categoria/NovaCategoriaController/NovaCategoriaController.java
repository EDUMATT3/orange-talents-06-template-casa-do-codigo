package com.zupacademy.eduardo.casadocodigo.categoria.NovaCategoriaController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

@RestController
@RequestMapping("categorias")
public class NovaCategoriaController {

    @PostMapping
    public ResponseEntity<?> novaCategoria(){
        return ResponseEntity.ok().build();
    }

}
