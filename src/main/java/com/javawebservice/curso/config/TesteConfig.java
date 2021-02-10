package com.javawebservice.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javawebservice.curso.entidades.Usuario;
import com.javawebservice.curso.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuario1 = new Usuario(null, "Bob", "bob@hotmail.com", "955695656", "1212");
		Usuario usuario2 = new Usuario(null, "Maria", "maria@uol.com.br", "958317578", "2525");
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
		
//		Arrays.asList(1, 2, 3, 4, 5).forEach(System.out::print);
		
		
		
	}
}
