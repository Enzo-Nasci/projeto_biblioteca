package projeto.api.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import projeto.api.biblioteca.dto.LivroRequest;
import projeto.api.biblioteca.dto.LivroResponse;
import projeto.api.biblioteca.entity.Livro;
import projeto.api.biblioteca.exceptions.LivroNaoEncontradoException;
import projeto.api.biblioteca.repository.LivroRepository;

import java.util.List;

@Service
public class LivroService {


    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }




    public List<LivroResponse> buscarLivros(){
        return livroRepository.findAll().stream().map(LivroResponse::new).toList();
    }

    public Boolean verificaLivroExiste(String isbn){
        return livroRepository.findLivroByIsbn(isbn).isPresent();
    }

    public Livro buscaLivro(String id){
        return livroRepository.findLivroById(id).orElseThrow(( ) -> new LivroNaoEncontradoException("Livro não encontrado"));
    }

    public LivroResponse adicionarLivro(LivroRequest livroRequest){
        Livro livro = new Livro();
        livro.setIsbn(livroRequest.isbn());
        livro.setNome(livroRequest.nome());
        livro.setPreco(livroRequest.preco());
        livro.setDtCriacao(livroRequest.dtCriacao());

        livroRepository.save(livro);

        return new LivroResponse(livro);
    }

    public LivroResponse deletaLivroPorId(String id){
        //TODO: LINKAR COM EMPRESTIMOREPOSITORY PARA APAGAR PRIMEIRO ELE DEPOIS O LIVRO

        Livro livro = buscaLivro(id);

        livroRepository.delete(livro);

        return new LivroResponse(livro);
    }



    public LivroResponse alteraLivro(String id,LivroRequest novoLivro){
        Livro livro = livroRepository.findLivroById(id).orElseThrow(() -> new LivroNaoEncontradoException("Livro não encontrado"));

        livro.setNome(novoLivro.nome());
        livro.setIsbn(novoLivro.isbn());
        livro.setPreco(novoLivro.preco());
        livro.setDtCriacao(novoLivro.dtCriacao());

        livroRepository.save(livro);

        return new LivroResponse(livro);
    }


    public LivroResponse alteraNomeLivro(String id,String newName){
        Livro livro = livroRepository.findLivroById(id).orElseThrow(() -> new LivroNaoEncontradoException("Livro não encontrado"));

        livro.setNome(newName);

        livroRepository.save(livro);

        return new LivroResponse(livro);
    }












}
