package com.javawebservice.curso.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javawebservice.curso.entidades.enums.PedidoStatus;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id Auto Incrementaval
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") // Transfrma data e hora que retorna do BD
	private Instant instante;
	
	private Integer pedidoStatus;
	
	@ManyToOne // Estabelece relação no banco de dados relacional entre tabelas
	@JoinColumn(name = "Cliente_id") // Cria um SQL JOIN na tabela da classe
	private Usuario cliente;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemDoPedido> itensDoPedido = new HashSet<>(); 
	
	public Pedido() {
	}

	public Pedido(Long id, Instant instante, PedidoStatus pedidoStatus, Usuario cliente) {
		this.id = id;
		this.instante = instante;
		setPedidoStatus(pedidoStatus);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getInstante() {
		return instante;
	}

	public void setInstante(Instant instante) {
		this.instante = instante;
	}

	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valorDe(pedidoStatus) ;
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if (pedidoStatus != null) {
			this.pedidoStatus = pedidoStatus.getCodigo();
		}
	}

	public Usuario getcliente() {
		return cliente;
	}

	public void setcliente(Usuario cliente) {
		this.cliente = cliente;
	}
	
	public Set<ItemDoPedido> getItensDoPedido(){
		return itensDoPedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", instante=" + instante + ", cliente=" + cliente + "]";
	}
	
	
	
}
