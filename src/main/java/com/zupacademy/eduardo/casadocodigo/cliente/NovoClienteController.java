package com.zupacademy.eduardo.casadocodigo.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("clientes")
public class NovoClienteController {

    @Autowired
    EstadoPertencePaisValidator estadoPertencePaisValidator;

    @PersistenceContext
    EntityManager entityManager;

    @InitBinder
    public void init(WebDataBinder dataBinder){
        dataBinder.addValidators(estadoPertencePaisValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoClienteRequest request){
        Cliente novoCliente = request.toModel(entityManager);
        entityManager.persist(novoCliente);
        return ResponseEntity.ok().build();
    }

}
