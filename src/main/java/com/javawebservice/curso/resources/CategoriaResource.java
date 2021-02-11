package com.javawebservice.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javawebservice.curso.entidades.Categoria;
import com.javawebservice.curso.services.CategoriaServices;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaServices service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos() {
		
		List<Categoria> listaCategorias = service.buscarTodos();
		
		return ResponseEntity.ok().body(listaCategorias);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id){
		Categoria categoria = service.buscarPorId(id);
		return ResponseEntity.ok().body(categoria);
	}
	
}
