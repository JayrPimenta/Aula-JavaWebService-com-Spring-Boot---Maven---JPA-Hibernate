package com.javawebservice.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javawebservice.curso.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	
}
