package com.zupacademy.eduardo.casadocodigo.categoria;

import com.zupacademy.eduardo.casadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    private String nome;

    public NovaCategoriaRequest() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
