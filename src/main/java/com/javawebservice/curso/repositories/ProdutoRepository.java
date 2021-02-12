package com.javawebservice.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javawebservice.curso.entidades.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
	
}
