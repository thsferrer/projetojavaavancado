package br.biblioteca.livros.repository;

import br.biblioteca.livros.entidades.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findByRole(String role);

}