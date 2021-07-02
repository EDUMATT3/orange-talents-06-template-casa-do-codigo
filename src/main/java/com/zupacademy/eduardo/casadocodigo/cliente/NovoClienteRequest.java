package com.zupacademy.eduardo.casadocodigo.cliente;

import com.zupacademy.eduardo.casadocodigo.compartilhado.Documento;
import com.zupacademy.eduardo.casadocodigo.compartilhado.ExistsValue;
import com.zupacademy.eduardo.casadocodigo.compartilhado.UniqueValue;
import com.zupacademy.eduardo.casadocodigo.estado.Estado;
import com.zupacademy.eduardo.casadocodigo.pais.Pais;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class NovoClienteRequest {

    @Email
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @Documento
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistsValue(domainClass = Pais.class)
    private Long paisId;
    @ExistsValue(domainClass = Estado.class)
    private Long estadoId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public NovoClienteRequest(String email, String nome, String sobrenome, String documento, String endereco,
                              String complemento, String cidade, Long paisId, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public Long getPaisId() {
        return this.paisId;
    }

    public Long getEstadoId() {
        return this.estadoId;
    }

    public Cliente toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, this.paisId);
        Assert.state(Objects.nonNull(pais), "País não encontrado com o id: "+ paisId);

        Cliente novoCliente = new Cliente(this.email,this.nome, this.sobrenome,this.documento, this.endereco, this.complemento,
                this.cidade, pais, this.telefone, this.cep);

        if(Objects.nonNull(this.estadoId)){
            Estado estado = entityManager.find(Estado.class, this.estadoId);
            Assert.state(Objects.nonNull(estado), "Estado não encontrado com o id: "+ estadoId);

            novoCliente.setEstado(estado);
        }

        return novoCliente;
    }
}
