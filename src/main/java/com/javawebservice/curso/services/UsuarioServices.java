package com.javawebservice.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawebservice.curso.entidades.Usuario;
import com.javawebservice.curso.repositories.UsuarioRepository;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();	
	}
	
	public Usuario buscarPorId(Long id) {	
//		Optional<Usuario> user = usuarioRepository.findById(id);
//		return user.get();	
		return usuarioRepository.findById(id).get();
	}
	
	public Usuario insert(Usuario usuario) {
		return usuarioRepository.save(usuario);	
	}
	
	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario update(Long id, Usuario usuario) {
		Usuario entidadeUsuario = usuarioRepository.getOne(id);
		updateData(entidadeUsuario, usuario);
		return usuarioRepository.save(entidadeUsuario);
	}

	private void updateData(Usuario entidadeUsuario, Usuario usuario) {
		entidadeUsuario.setNome(usuario.getNome());
		entidadeUsuario.setEmail(usuario.getEmail());
		entidadeUsuario.setTel(usuario.getTel());
	}
}
