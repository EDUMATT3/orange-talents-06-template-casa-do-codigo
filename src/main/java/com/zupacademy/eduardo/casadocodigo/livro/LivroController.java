package com.zupacademy.eduardo.casadocodigo.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("livros")
public class LivroController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createBook(@Valid @RequestBody NovoLivroRequest request){
        Livro novoLivro = request.toModel(entityManager);
        entityManager.persist(novoLivro);
        return ResponseEntity.created(URI.create("/livros/"+novoLivro.getId())).build();
    }

    @GetMapping
    public List<LivroResponse> listarLivros(){
        return entityManager.createQuery("from Livro", Livro.class)
            .getResultList()
            .stream()
            .map(LivroResponse::new)
            .collect(Collectors.toList());
    }
}
