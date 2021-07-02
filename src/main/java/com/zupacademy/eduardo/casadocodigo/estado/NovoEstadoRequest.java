package com.zupacademy.eduardo.casadocodigo.estado;

import com.zupacademy.eduardo.casadocodigo.categoria.Categoria;
import com.zupacademy.eduardo.casadocodigo.compartilhado.ExistsValue;
import com.zupacademy.eduardo.casadocodigo.compartilhado.UniqueValue;
import com.zupacademy.eduardo.casadocodigo.pais.Pais;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class NovoEstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @ExistsValue(domainClass = Pais.class)
    private Long paisId;

    public NovoEstadoRequest(@NotBlank String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, this.paisId);
        Assert.state(Objects.nonNull(pais), "Categoria não encontrada com o id: "+ paisId);

        return new Estado(this.nome, pais);
    }
}
