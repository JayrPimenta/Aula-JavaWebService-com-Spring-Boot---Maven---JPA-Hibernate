package com.javawebservice.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javawebservice.curso.entidades.Categoria;
import com.javawebservice.curso.entidades.Pedido;
import com.javawebservice.curso.entidades.Produto;
import com.javawebservice.curso.entidades.Usuario;
import com.javawebservice.curso.entidades.enums.PedidoStatus;
import com.javawebservice.curso.repositories.CategoriaRepository;
import com.javawebservice.curso.repositories.PedidoRepository;
import com.javawebservice.curso.repositories.ProdutoRepository;
import com.javawebservice.curso.repositories.UsuarioRepository;





@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{ 
// CommandLineRunner interface que permite implementar um acesso ao console

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "Eletronicos");
		Categoria categoria2 = new Categoria(null, "Livros");
		Categoria categoria3 = new Categoria(null, "Computadores");
		
		Produto produto1 = new Produto(null, "Senhor dos Anes", "Livros capa e espada", 90.0, "");
		Produto produto2 = new Produto(null, "Smart TV", "43 polegadas", 2100.0, "");
		Produto produto3 = new Produto(null, "Notebook Asus", "Intel CORE I5 8 Memoria Ram e 1Tb de HD", 1750.0, "");
		Produto produto4 = new Produto(null, "PC Gamer", "Ryzen 7, 16GB RAM e GTX 3080TI", 6035.45, "");
		Produto produto5 = new Produto(null, "DRACULA", "O Vampiro mais famoso dos cinemas", 58.0, "");
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		// Associação de produtos com as categorias
		
		produto1.getCategorias().add(categoria2);
		produto2.getCategorias().add(categoria1);
		produto3.getCategorias().add(categoria1);
		produto3.getCategorias().add(categoria2);
		produto3.getCategorias().add(categoria3);
		produto4.getCategorias().add(categoria1);
		produto4.getCategorias().add(categoria3);
		produto5.getCategorias().add(categoria2);
		
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		Usuario usuario1 = new Usuario(null, "Bob", "bob@hotmail.com", "955695656", "1212");
		Usuario usuario2 = new Usuario(null, "Maria", "maria@uol.com.br", "958317578", "2525");

		Pedido pedido1 = new Pedido(null, Instant.parse("2020-12-23T16:29:12Z"), PedidoStatus.PAGO, usuario1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2021-01-16T09:58:02Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, usuario2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2021-02-07T13:03:56Z"), PedidoStatus.ENVIADO,usuario1);
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
		
//		Teste de erro: resolvido
//		Arrays.asList(1, 2, 3, 4, 5).forEach(System.out::print);
		
		
		
	}
}
