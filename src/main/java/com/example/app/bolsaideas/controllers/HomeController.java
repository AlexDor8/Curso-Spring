package com.example.app.bolsaideas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.bolsaideas.models.Usuario;

@Controller
@RequestMapping("/app")
public class HomeController {
	
	@RequestMapping(value={"/index","/home","/", ""}, method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework");
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Alex");
		usuario.setApellido("Dorado");
		usuario.setEmail("dorado.casado.alex@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Hola Spring Framework ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		/**List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Alex", "Dorado", "alex@gmail.com"));
		usuarios.add(new Usuario("Pedro", "Casado", "pedro@gmail.com"));
		usuarios.add(new Usuario("Paco", "Ruiz", "paco@gmail.com"));**/
		model.addAttribute("titulo", "Listado de usuarios");
		//model.addAttribute("usuarios", usuarios);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> pasarUsuario() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Alex", "Dorado", "alex@gmail.com"));
		usuarios.add(new Usuario("Pedro", "Casado", "pedro@gmail.com"));
		usuarios.add(new Usuario("Paco", "Ruiz", "paco@gmail.com"));
		return usuarios;
	}
	
}
