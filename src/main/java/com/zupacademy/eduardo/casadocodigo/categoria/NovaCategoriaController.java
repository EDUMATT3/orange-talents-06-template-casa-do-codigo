package com.zupacademy.eduardo.casadocodigo.categoria;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("categorias")
public class NovaCategoriaController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> novaCategoria(@RequestBody @Valid NovaCategoriaRequest request){

        Categoria novaCategoria = request.toModel();
        entityManager.persist(novaCategoria);

        return ResponseEntity.ok().build();
    }

}
