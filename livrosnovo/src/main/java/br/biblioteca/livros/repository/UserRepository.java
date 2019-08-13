package br.biblioteca.livros.repository;

import br.biblioteca.livros.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<Login, String> {

    public Login findByUsername(String username);

}
