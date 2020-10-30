package com.co.compras.service;

import java.util.Optional;

import com.co.compras.dto.VentaDTO;
import com.co.compras.entity.Venta;

public interface IVentaService {

	public Optional<Venta> registrarVenta(VentaDTO venta);
	
	public Optional<Venta> consultarVenta(Long id);
}
