package br.biblioteca.livros.controladores;

import br.biblioteca.livros.entities.Livro;
import br.biblioteca.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Index {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @RequestMapping("/livros")
    public ModelAndView livros() {
        Iterable<Livro> livros = livroRepository.findAll();
        return new ModelAndView("livros", "livros", livros);
    }

}

