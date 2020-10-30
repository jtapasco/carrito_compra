package com.co.compras.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.compras.dto.ResponseDTO;
import com.co.compras.dto.VentaDTO;
import com.co.compras.entity.Venta;
import com.co.compras.service.IVentaService;
import com.co.compras.utils.Constantes;
import com.sun.istack.NotNull;

@RestController
@RequestMapping(value = "/api/venta", produces = MediaType.APPLICATION_JSON_VALUE, 
	consumes = MediaType.APPLICATION_JSON_VALUE)
public class VentaController {
	
	private final Logger log = LoggerFactory.getLogger(VentaController.class);
	
	@Autowired
	IVentaService ventaService;

	@PostMapping("/registrar")
	public ResponseEntity registrarVenta(@Validated @RequestBody VentaDTO venta) {

		Optional<Venta> ventaResponse = ventaService.registrarVenta(venta);

		if (ventaResponse != null) {
			log.debug("Registro creado correctamente");
			return ResponseEntity.ok(ventaResponse);
		}

		ResponseDTO response = new ResponseDTO();
		response.setHttpStatus(HttpStatus.NO_CONTENT.value());
		response.setMessage("Registro no creado en la BD");
		response.setCode(Constantes.CODIGO_ERROR_001);
		response.setBackendMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
		
		log.error(response.toString());

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity consultarVenta(@PathVariable @NotNull Long id) {
		Optional<Venta> ventaResponse = ventaService.consultarVenta(id);
		if (ventaResponse.isPresent()) {
			log.debug("Registro encontrado correctamente");
			return ResponseEntity.ok(ventaResponse.get());
		}else {
			ResponseDTO response = new ResponseDTO();
			response.setHttpStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("Registro no encontrado en la BD");
			response.setCode(Constantes.CODIGO_ERROR_002);
			response.setBackendMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
			
			log.error(response.toString());

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}
}
