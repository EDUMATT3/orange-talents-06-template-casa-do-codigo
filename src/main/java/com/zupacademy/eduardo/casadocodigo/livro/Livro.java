package com.zupacademy.eduardo.casadocodigo.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zupacademy.eduardo.casadocodigo.autor.Autor;
import com.zupacademy.eduardo.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(value = 20)
    private BigDecimal preco;

    @NotNull
    @Min(value = 100)
    private int numeroPaginas;

    @NotBlank
    private String isbn;

    @Future
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate publicacao;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotNull
    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() {}

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, int numeroPaginas, String isbn, LocalDate publicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.publicacao = publicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId(){
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Livro)) {
            return false;
        }
        Livro book = (Livro) o;
        return Objects.equals(isbn, book.isbn);
    }

    public String getTitulo() {
        return this.titulo;
    }
}