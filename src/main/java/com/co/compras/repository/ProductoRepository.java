package com.co.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.compras.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	

}
