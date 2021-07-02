package com.zupacademy.eduardo.casadocodigo.pais;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paises")
public class NovoPaisController {

    @PostMapping
    public ResponseEntity<?> cadastrar(){
        return ResponseEntity.ok().build();
    }
}
