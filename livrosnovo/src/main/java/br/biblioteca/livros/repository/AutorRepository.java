package br.biblioteca.livros.repository;


import br.biblioteca.livros.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}

