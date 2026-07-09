package projeto.api.biblioteca.exceptions;

public class LivroNaoEncontradoException extends RuntimeException{
    public LivroNaoEncontradoException(String message){
        super(message);
    }

    public LivroNaoEncontradoException(){
        super("Livro não encontrado");
    }

}
