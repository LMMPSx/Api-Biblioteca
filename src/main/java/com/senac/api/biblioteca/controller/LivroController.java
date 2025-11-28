package com.senac.api.biblioteca.controller;

import com.senac.api.biblioteca.model.LivroModel;
import com.senac.api.biblioteca.repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@AllArgsConstructor
public class LivroController {
    private final LivroRepository livroRepository;

    @GetMapping
    public List<LivroModel> getAllLivros() {
        return livroRepository.findAll();
    }

    @PostMapping("/create")
    public LivroModel createLivro(@RequestBody LivroModel livro) {
        return livroRepository.save(livro);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<LivroModel> getLivroById(@PathVariable Integer id) {
        return livroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<LivroModel> getLivroByTitulo(@PathVariable String titulo) {
        return livroRepository.findByTitulo(titulo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<LivroModel> getLivroByAutor(@PathVariable String autor) {
        return livroRepository.findByAutor(autor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<LivroModel> getLivroByIsbn(@PathVariable String isbn) {
        return livroRepository.findByIsbn(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ano/{anoPublicacao}")
    public ResponseEntity<LivroModel> getLivroByAnoPublicacao(@PathVariable String anoPublicacao) {
        return livroRepository.findByAnoPublicacao(anoPublicacao)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<LivroModel> updateLivro(@PathVariable Integer id, @RequestBody LivroModel livro) {
        return livroRepository.findById(id)
                .map(livroModel -> {
                    if (livro.getTitulo() != null) {
                        livroModel.setTitulo(livro.getTitulo());
                    }
                    if (livro.getAutor() != null) {
                        livroModel.setAutor(livro.getAutor());
                    }
                    if (livro.getIsbn() != null) {
                        livroModel.setIsbn(livro.getIsbn());
                    }
                    if (livro.getAnoPublicacao() != null) {
                        livroModel.setAnoPublicacao(livro.getAnoPublicacao());
                    }
                    if (livro.getDisponivel() != null) {
                        livroModel.setDisponivel(livro.getDisponivel());
                    }
                    LivroModel updatedLivro = livroRepository.save(livroModel);
                    return ResponseEntity.ok(updatedLivro);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Integer id) {
        if(livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
