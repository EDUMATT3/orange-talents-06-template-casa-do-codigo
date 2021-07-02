package com.zupacademy.eduardo.casadocodigo.pais;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("paises")
public class NovoPaisController {

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoPaisRequest novoPaisRequest){
        return ResponseEntity.ok(novoPaisRequest.getNome());
    }
}
