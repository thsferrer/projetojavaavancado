package br.biblioteca.livros.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityService {
 
  String findLoggedInUsername ();

  UserDetails findLoggedInUser ();
 
  void login (String username, String password) throws BadCredentialsException;

}
