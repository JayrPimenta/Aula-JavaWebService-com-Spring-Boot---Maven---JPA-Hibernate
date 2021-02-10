package com.javawebservice.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawebservice.curso.entidades.Pedido;
import com.javawebservice.curso.repositories.PedidoRepository;

@Service
public class PedidoServices {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> buscarTodos() {
		return pedidoRepository.findAll();
		
	}
	
	public Pedido buscarPorId(Long id) {
		
//		Optional<Pedido> pedido = pedidoRepository.findById(id);
//		return pedido.get();
		
		return pedidoRepository.findById(id).get();
	}
}
