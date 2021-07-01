package com.zupacademy.eduardo.casadocodigo.autor;

public class DetalheLivroAutorResponse {

    private String nome;
    private String descricao;

    public DetalheLivroAutorResponse(Autor autor) {
        nome = autor.getNome();
        descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
