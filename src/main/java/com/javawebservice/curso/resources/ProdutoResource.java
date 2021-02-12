package com.javawebservice.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javawebservice.curso.entidades.Produto;
import com.javawebservice.curso.services.ProdutoServices;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoServices service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos() {
		
		List<Produto> listaProdutos = service.buscarTodos();
		
		return ResponseEntity.ok().body(listaProdutos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
		Produto produto = service.buscarPorId(id);
		return ResponseEntity.ok().body(produto);
	}
	
}
