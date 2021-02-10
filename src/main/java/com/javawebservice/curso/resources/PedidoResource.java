package com.javawebservice.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javawebservice.curso.entidades.Pedido;
import com.javawebservice.curso.services.PedidoServices;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoServices service;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> buscarTodos() {
		
		List<Pedido> listaPedidos = service.buscarTodos();
		
		return ResponseEntity.ok().body(listaPedidos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id){
		Pedido pedido = service.buscarPorId(id);
		return ResponseEntity.ok().body(pedido);
	}
	
}
