package br.biblioteca.livros.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Login implements Serializable {

    private static final long serialVersionUID = 6987502270876995514L;

    @Id
    private String username;

    private String password;

    public Login () { }

    public Login (String username, String password) {
        this.username = username;
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", roles=" + roles + "]";
    }
}
