package com.javawebservice.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawebservice.curso.entidades.Pedido;
import com.javawebservice.curso.repositories.PedidoRepository;

@Service // Transforma a classe em um componente do Spring Boot
public class PedidoServices {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> buscarTodos() {
		return pedidoRepository.findAll();
		
	}
	
	public Pedido buscarPorId(Long id) {
	
//      Logica do professor
//		Optional<Pedido> pedido = pedidoRepository.findById(id);
//		return pedido.get();
		
//		Minha logica - abreviar
		return pedidoRepository.findById(id).get();
	}
}
