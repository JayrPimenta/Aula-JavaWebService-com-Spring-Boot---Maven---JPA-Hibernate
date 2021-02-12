package com.javawebservice.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawebservice.curso.entidades.Produto;
import com.javawebservice.curso.repositories.ProdutoRepository;

@Service
public class ProdutoServices {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
		
	}
	
	public Produto buscarPorId(Long id) {
		
//		Optional<Usuario> user = usuarioRepository.findById(id);
//		return user.get();
		
		return produtoRepository.findById(id).get();
	}
}
