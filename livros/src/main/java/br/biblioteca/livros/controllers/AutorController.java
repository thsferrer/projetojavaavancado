package br.biblioteca.livros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Autor;

@RequestMapping("/autores")
@Controller
public class AutorController {
	
	@GetMapping("/listarAutor")
	public ModelAndView listarautor() 
	{
		System.out.println("Listei os autores");
		return new ModelAndView("/autores/list");
	}
	
	@GetMapping("/novoAutor")
	public ModelAndView newAutor() 
	{
		System.out.println("Criei novo autor");
		return new ModelAndView("/autores/autor");
	}
	
	@PostMapping(value = "/gravarAutor")
	public ModelAndView create(Autor autor) 
	{
		System.out.println("Gravei o autor");
	   return new ModelAndView("redirect:/autores/list");
	}

	@GetMapping("/alterArautor/{id}")
	public ModelAndView update(@PathVariable("id") Long id) 
	{
		System.out.println("Alterei o autor com ID: " + id);
		return new ModelAndView("redirect:/autores/list");
	}
	
	@GetMapping("/excluirautor/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) 
	{
		System.out.println("Excluí o autor com ID: " + id);
		return new ModelAndView("redirect:/autores/list");
	}
}
