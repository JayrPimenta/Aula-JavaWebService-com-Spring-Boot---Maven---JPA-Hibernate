package com.javawebservice.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javawebservice.curso.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	
	
}
