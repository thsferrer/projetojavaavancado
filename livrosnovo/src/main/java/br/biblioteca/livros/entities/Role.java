package br.biblioteca.livros.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {

    private static final long serialVersionUID = 8851127886412536722L;

    @Id
    @GeneratedValue
    public Long id;

    public String role;

    public Role() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role [role=" + role + "]";
    }
}