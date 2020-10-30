package com.co.compras.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.compras.dto.ResponseDTO;
import com.co.compras.entity.Producto;
import com.co.compras.service.IProductoService;
import com.co.compras.utils.Constantes;
import com.sun.istack.NotNull;

@RestController
@RequestMapping(value = "/api/producto", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductoController {
	
	private final Logger log = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private IProductoService productoService;

	@PostMapping("/registrarProducto")
	public ResponseEntity registrarProducto(@Validated @RequestBody Producto producto) {

		
		Producto productoResponse = productoService.registrarProducto(producto);

		if (productoResponse != null) {
			log.debug("Registro creado correctamente");
			return ResponseEntity.ok(productoResponse);
		}

		ResponseDTO response = new ResponseDTO();
		response.setHttpStatus(HttpStatus.NO_CONTENT.value());
		response.setMessage("Registro no creado en la BD");
		response.setCode(Constantes.CODIGO_ERROR_001);
		response.setBackendMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
		
		log.error(response.toString());

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity buscarProducto(@PathVariable @NotNull Long id) {
		Optional<Producto> producto = productoService.buscarProducto(id);
		if (producto.isPresent()) {
			log.debug("Registro encontrado");
			return ResponseEntity.ok(producto.get());
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
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity eliminarProducto(@PathVariable @NotNull Long id) {
		try {
			productoService.eliminarProducto(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			ResponseDTO response = new ResponseDTO();
			response.setHttpStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Registro no encontrado en la BD");
			response.setCode(Constantes.CODIGO_ERROR_002);
			response.setBackendMessage(e.getMessage());

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity actualizarProducto(@Validated @RequestBody Producto producto) {
		try {
			productoService.actualizarProducto(producto);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			ResponseDTO response = new ResponseDTO();
			response.setHttpStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Registro no encontrado en la BD");
			response.setCode(Constantes.CODIGO_ERROR_002);
			response.setBackendMessage(e.getMessage());

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
}
