package com.co.compras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.compras.entity.DetalleVenta;

public interface DetalleVentaRespository extends JpaRepository<DetalleVenta, Long> {
	
	public List<DetalleVenta>findByVenta(Long idVenta);

}
