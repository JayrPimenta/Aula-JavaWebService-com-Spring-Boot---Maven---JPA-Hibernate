package com.javawebservice.curso.config;

import java.time.Instant;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javawebservice.curso.entidades.Pedido;
import com.javawebservice.curso.entidades.Usuario;
import com.javawebservice.curso.repositories.PedidoRepository;
import com.javawebservice.curso.repositories.UsuarioRepository;





@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuario1 = new Usuario(null, "Bob", "bob@hotmail.com", "955695656", "1212");
		Usuario usuario2 = new Usuario(null, "Maria", "maria@uol.com.br", "958317578", "2525");

		Pedido pedido1 = new Pedido(null, Instant.parse("2020-12-23T16:29:12Z"), usuario1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2021-01-16T09:58:02Z"), usuario2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2021-02-07T13:03:56Z"), usuario1);
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
//		Arrays.asList(1, 2, 3, 4, 5).forEach(System.out::print);
		
		
		
	}
}
