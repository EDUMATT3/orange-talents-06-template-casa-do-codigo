package com.zupacademy.eduardo.casadocodigo.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zupacademy.eduardo.casadocodigo.autor.Autor;
import com.zupacademy.eduardo.casadocodigo.categoria.Categoria;
import com.zupacademy.eduardo.casadocodigo.compartilhado.UniqueValue;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class NovoLivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private int numeroPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern="dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicacao;

    @NotNull
    private Long categoriaId;

    @NotNull
    private Long autorId;

    public NovoLivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, int numeroPaginas, String isbn, Long categoriaId, Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public Livro toModel(EntityManager entityManager) {

        Categoria categoria = entityManager.find(Categoria.class, this.categoriaId);
        Assert.state(Objects.nonNull(categoria), "Categoria não encontrada com o id: "+ categoriaId);

        Autor autor = entityManager.find(Autor.class, autorId);
        Assert.state(Objects.nonNull(autor), "Autor(a) não encontrado(a) com o id: "+ autorId);

        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, publicacao, categoria, autor);
    }

    public void setPublicacao(LocalDate publicacao){
        this.publicacao = publicacao;
    }
}
