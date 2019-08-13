package br.biblioteca.livros.controladores;

import java.util.List;

import br.biblioteca.livros.entities.Login;
import br.biblioteca.livros.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserControllers {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public ModelAndView list() {
		List<Login> users = userService.findAll();
		return new ModelAndView("user/list", "users", users);
	}

	@GetMapping("/listadmin")
	public ModelAndView listadmin(Login user) {
		List<Login> users = userService.findAll();
		return new ModelAndView("user/listadmin", "users", users);
	}
}
