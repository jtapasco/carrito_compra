package com.co.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.compras.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
	
	

}
