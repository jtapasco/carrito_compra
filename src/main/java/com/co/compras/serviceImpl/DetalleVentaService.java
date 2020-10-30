package com.co.compras.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.compras.entity.DetalleVenta;
import com.co.compras.repository.DetalleVentaRespository;
import com.co.compras.service.IDetalleVentaService;

@Service
public class DetalleVentaService implements IDetalleVentaService {
	
	@Autowired
	private DetalleVentaRespository detalleRepository;

	@Override
	public void registrarDetalleVenta(DetalleVenta detalle) {
		detalleRepository.save(detalle);
	}

	@Override
	public DetalleVenta buscarDetalleVenta(Long idDetalle) {
		return detalleRepository.findById(idDetalle).orElseGet(null);
	}

}
