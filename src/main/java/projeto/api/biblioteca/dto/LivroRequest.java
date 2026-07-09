


package projeto.api.biblioteca.dto;


import java.util.Date;

public record LivroRequest (String nome, Double preco, String isbn, Date dtCriacao) {
}
