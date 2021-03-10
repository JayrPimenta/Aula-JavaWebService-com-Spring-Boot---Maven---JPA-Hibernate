package com.javawebservice.curso.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.javawebservice.curso.entidades.Usuario;
import com.javawebservice.curso.repositories.UsuarioRepository;
import com.javawebservice.curso.services.exceptions.DatabaseException;
import com.javawebservice.curso.services.exceptions.ResourceNotFoundException;

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
//		return usuarioRepository.findById(id).get();
		return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Usuario insert(Usuario usuario) {
		return usuarioRepository.save(usuario);	
	}
	
	public void delete(Long id) {
		try {
			usuarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException msg) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException msg) {
			throw new DatabaseException(msg.getMessage());
		}
	}
	
	public Usuario update(Long id, Usuario usuario) {
		try {
			Usuario entidadeUsuario = usuarioRepository.getOne(id);
			updateData(entidadeUsuario, usuario);
			return usuarioRepository.save(entidadeUsuario);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Usuario entidadeUsuario, Usuario usuario) {
		entidadeUsuario.setNome(usuario.getNome());
		entidadeUsuario.setEmail(usuario.getEmail());
		entidadeUsuario.setTel(usuario.getTel());
	}
}
