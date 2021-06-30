package com.zupacademy.eduardo.casadocodigo.autor;

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
@RequestMapping("autores")
public class NovoAutorController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity<?> novoAutor(@RequestBody @Valid NovoAutorRequest novoAutorRequest){
        Autor novoAutor = novoAutorRequest.toModel();
        em.persist(novoAutor);
        return ResponseEntity.ok().build();
    }

}
