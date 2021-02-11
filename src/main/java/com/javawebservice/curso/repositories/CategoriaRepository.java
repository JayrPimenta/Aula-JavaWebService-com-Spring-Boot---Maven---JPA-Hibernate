package com.javawebservice.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javawebservice.curso.entidades.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	
	
}
