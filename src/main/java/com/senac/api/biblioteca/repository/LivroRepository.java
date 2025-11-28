package com.senac.api.biblioteca.repository;

import com.senac.api.biblioteca.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Integer> {
    Optional<LivroModel> findByTitulo(String titulo);
    Optional<LivroModel> findByAutor(String autor);
    Optional<LivroModel> findByIsbn(String isbn);
    Optional<LivroModel> findByAnoPublicacao(String anoPublicacao);
}
