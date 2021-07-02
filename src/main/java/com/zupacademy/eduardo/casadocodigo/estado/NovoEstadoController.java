package com.zupacademy.eduardo.casadocodigo.estado;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("estados")
public class NovoEstadoController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    EstadoUnicoPaisValidator estadoUnicoPaisValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder){
        dataBinder.addValidators(estadoUnicoPaisValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoEstadoRequest request){
        Estado novoEstado = request.toModel(entityManager);
        entityManager.persist(novoEstado);

        return ResponseEntity.ok().build();
    }

}
