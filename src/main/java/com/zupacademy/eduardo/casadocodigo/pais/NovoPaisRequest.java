package com.zupacademy.eduardo.casadocodigo.pais;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.zupacademy.eduardo.casadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    private String nome;

    @JsonCreator
    public NovoPaisRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
