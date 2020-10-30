package com.co.compras.serviceImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.compras.dto.VentaDTO;
import com.co.compras.entity.DetalleVenta;
import com.co.compras.entity.Venta;
import com.co.compras.repository.VentaRepository;
import com.co.compras.service.IVentaService;

@Service
public class VentaService implements IVentaService {
	
	@Autowired
	VentaRepository ventaRepository;
	
	@Autowired
	DetalleVentaService detalleVentaService;

	@Override
	public Optional<Venta> registrarVenta(VentaDTO venta) {

		Venta ventaReg = new Venta();
		ventaReg.setCliente(venta.getCliente());
		ventaReg.setFecha(new Date());

		Optional<Venta> optional = Optional.ofNullable(ventaRepository.save(ventaReg));

		if (optional.isPresent()) {
			Venta ventaResp = optional.get();
			List<DetalleVenta> detalleList = venta.getProductos().stream().map(x -> {
				DetalleVenta detalle = new DetalleVenta();
				detalle.setVenta(ventaResp);
				detalle.setProducto(x);
				return detalle;
			}).collect(Collectors.toList());

			for (DetalleVenta detalleVenta : detalleList) {
				detalleVentaService.registrarDetalleVenta(detalleVenta);
			}

			return consultarVenta(ventaReg.getIdVenta());
		}
		return optional;
	}

	@Override
	public Optional<Venta> consultarVenta(Long id) {
		return ventaRepository.findById(id);
	}

}
