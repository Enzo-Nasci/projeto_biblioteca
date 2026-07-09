package projeto.api.biblioteca.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.api.biblioteca.dto.LivroRequest;
import projeto.api.biblioteca.dto.LivroResponse;
import projeto.api.biblioteca.service.LivroService;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }


    @GetMapping()
    public ResponseEntity<List<LivroResponse>> findAllLivros(){
        return ResponseEntity.ok(service.buscarLivros());
    }

    @PostMapping()
    public ResponseEntity<LivroResponse> createLivro(@RequestBody LivroRequest livroRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarLivro(livroRequest));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LivroResponse> deleteLivro(@PathVariable String id)
    {
        return ResponseEntity.ok(service.deletaLivroPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponse> alteraLivro(@PathVariable String id, @RequestBody LivroRequest livroRequest) {
        return  ResponseEntity.ok(service.alteraLivro(id,livroRequest));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<LivroResponse> alteraNomeLivro(@PathVariable String id, @RequestBody String nome){
        return ResponseEntity.ok(service.alteraNomeLivro(id,nome));
    }





}
