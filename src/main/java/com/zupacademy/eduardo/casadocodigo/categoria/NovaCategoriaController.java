package com.zupacademy.eduardo.casadocodigo.categoria;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("categorias")
public class NovaCategoriaController {

    @PostMapping
    public ResponseEntity<?> novaCategoria(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest){
        return ResponseEntity.ok().body(novaCategoriaRequest.toString());
    }

}
