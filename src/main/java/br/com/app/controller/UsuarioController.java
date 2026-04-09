package br.com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.entity.Usuario;
import br.com.app.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public List<Usuario>procurarTodos(){
		return service.procurarTodos();
	}
	@GetMapping(value = "/{id}")
	public Usuario procurarPorId(@PathVariable Integer id) {
		return service.procurarPorId(id);
	}
	@PostMapping
	public String adicionarUsuario(@RequestBody Usuario usuario) {
		String response = service.adicionarUsuario(usuario);
		return response;
	}
	@PutMapping(value = "/{id}")
	public String editarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
		String response = service.editarUsuario(id, usuario);
		return response;
	}
	@DeleteMapping(value = "/{id}")
	public void excluirUsuario(@PathVariable Integer id) {
	service.excluirUsuario(id);
	}
}
