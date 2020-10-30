package com.co.compras.service;

import com.co.compras.entity.DetalleVenta;

public interface IDetalleVentaService {
	
	public void registrarDetalleVenta(DetalleVenta detalle);
	
	public DetalleVenta buscarDetalleVenta(Long idVenta);

}
