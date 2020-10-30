package com.co.compras.dto;

import java.io.Serializable;
import java.util.List;

import com.co.compras.entity.Cliente;
import com.co.compras.entity.Producto;

public class VentaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	
	private List<Producto> productos;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	
	
}
