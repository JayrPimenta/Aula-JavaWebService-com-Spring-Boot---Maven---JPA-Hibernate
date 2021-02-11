package com.javawebservice.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawebservice.curso.entidades.Categoria;
import com.javawebservice.curso.repositories.CategoriaRepository;

@Service
public class CategoriaServices {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> buscarTodos() {
		return categoriaRepository.findAll();
		
	}
	
	public Categoria buscarPorId(Long id) {
		
//		Optional<Usuario> user = usuarioRepository.findById(id);
//		return user.get();
		
		return categoriaRepository.findById(id).get();
	}
}
