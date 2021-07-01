package com.zupacademy.eduardo.casadocodigo.livro;

import com.zupacademy.eduardo.casadocodigo.autor.DetalheLivroAutorResponse;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalheLivroResponse {

    private DetalheLivroAutorResponse autor;
    private String titulo;
    private String isbn;
    private int numeroPaginas;
    private BigDecimal preco;
    private String resumo;
    private String sumario;
    private LocalDate publicacao;

    public DetalheLivroResponse(Livro livro) {
        titulo = livro.getTitulo();
        autor = new DetalheLivroAutorResponse(livro.getAutor());
        isbn = livro.getIsbn();
        numeroPaginas = livro.getNumeroPaginas();
        preco = livro.getPreco();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        publicacao = livro.getPublicacao();

    }

    public LocalDate getPublicacao() {
        return this.publicacao;
    }

    public DetalheLivroAutorResponse getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }
}
