package com.javawebservice.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javawebservice.curso.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@GetMapping
	public ResponseEntity<Usuario> buscarTodos() {
		Usuario user = new Usuario(1l, "Jayr", "jayr.pimenta@gmail.com", "998146022", "1234");
		return ResponseEntity.ok().body(user);
	}
	
}
