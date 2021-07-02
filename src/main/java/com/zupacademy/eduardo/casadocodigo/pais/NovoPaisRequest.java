package com.zupacademy.eduardo.casadocodigo.pais;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.zupacademy.eduardo.casadocodigo.categoria.Categoria;
import com.zupacademy.eduardo.casadocodigo.compartilhado.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class NovoPaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    @JsonCreator
    public NovoPaisRequest(String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }
}
