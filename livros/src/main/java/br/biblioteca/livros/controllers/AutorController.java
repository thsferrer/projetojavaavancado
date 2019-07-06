package br.biblioteca.livros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Autor;
import br.biblioteca.livros.service.AutorService;

@RequestMapping("/autores")
@Controller
public class AutorController {
	
	@Autowired
	AutorService autorService;

	@GetMapping("/list")
	public ModelAndView list() 
	{
		List<Autor> autores = autorService.listarAutores();
		return new ModelAndView("autores/list", "listarAutores", autores);
	}
	
	@GetMapping("/novo")
	public ModelAndView newAutor(@ModelAttribute Autor autor)
	{
		ModelAndView modelAndView = new ModelAndView("autores/autor");
		Iterable<Autor> autores = autorService.listarAutores();
		modelAndView.addObject("autores", autores);
		return modelAndView;
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		autorService.apagarAutor(id);
		return new ModelAndView("redirect:/autores/list");
	}

	@PostMapping(value = "/gravar")
	public ModelAndView create(Autor autor) {
		autorService.salvaAutor(autor);
		return new ModelAndView("redirect:/autores/list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView update(@PathVariable("id") Long id) {
		Autor autor = autorService.buscarAutor(id);
		ModelAndView modelAndView = new ModelAndView("autores/autor");
		modelAndView.addObject("autor", autor);
		return modelAndView;
	}
}
