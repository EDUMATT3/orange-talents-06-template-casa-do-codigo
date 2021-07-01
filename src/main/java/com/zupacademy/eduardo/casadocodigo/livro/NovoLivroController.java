package com.zupacademy.eduardo.casadocodigo.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("livros")
public class NovoLivroController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createBook(@Valid @RequestBody NovoLivroRequest request){
        Livro novoLivro = request.toModel(entityManager);
        entityManager.persist(novoLivro);
        return ResponseEntity.created(URI.create("/books/"+novoLivro.getId())).build();
    }
}
