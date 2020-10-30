package com.co.compras.service;

import java.util.Optional;

import com.co.compras.entity.Producto;

public interface IProductoService {
	
	public Producto registrarProducto(Producto producto);
	
	public Optional<Producto> buscarProducto(Long id);
	
	public void eliminarProducto(Long id);
	
	public Optional<Producto> actualizarProducto(Producto producto);

}
