package projeto.api.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import projeto.api.biblioteca.entity.Livro;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<Livro, String> {

    Optional<Livro> findLivroById(String id);

    Optional<Livro> findLivroByIsbn(String isbn);



    @Procedure(procedureName = "realizar_compra")
    Void realizaCompra(String idLivro,String idUsuario,Integer quantidade);

}
