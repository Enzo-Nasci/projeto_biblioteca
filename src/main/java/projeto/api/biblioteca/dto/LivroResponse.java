package projeto.api.biblioteca.dto;

import projeto.api.biblioteca.entity.Livro;

import java.util.Date;

public class LivroResponse{
    private final String nome;
    private final String isbn;
    private final Double preco;
    private final Date dtCriacao;
    public LivroResponse (Livro livro){
        this.isbn = livro.getIsbn();
        this.nome = livro.getNome();
        this.preco = livro.getPreco();
        this.dtCriacao = livro.getDtCriacao();

    }
}
