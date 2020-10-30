package com.co.compras.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.compras.entity.Producto;
import com.co.compras.repository.ProductoRepository;
import com.co.compras.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public Producto registrarProducto(Producto producto) {
		Producto productoReturn = productoRepository.save(producto);
		return productoReturn;
	}

	@Override
	public Optional<Producto> buscarProducto(Long id) {
		
		return productoRepository.findById(id);
	}

	@Override
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
		
	}

	@Override
	public Optional<Producto> actualizarProducto(Producto producto) {
		return Optional.of(productoRepository.save(producto));
		
	}

}
