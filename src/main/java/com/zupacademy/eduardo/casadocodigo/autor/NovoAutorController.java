package com.zupacademy.eduardo.casadocodigo.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("autores")
public class NovoAutorController {

    @PostMapping
    public ResponseEntity<?> novoAutor(@RequestBody @Valid NovoAutorRequest novoAutorRequest){
        return ResponseEntity.ok().body(novoAutorRequest.toString());
    }

}
