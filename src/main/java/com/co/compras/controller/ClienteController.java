package com.co.compras.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.compras.dto.ResponseDTO;
import com.co.compras.entity.Cliente;
import com.co.compras.service.IClienteService;
import com.co.compras.utils.Constantes;

@RestController
@RequestMapping(value = "/api/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {
	
	private final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	IClienteService clienteService;
	
	@PostMapping("/registrar")
	public ResponseEntity registrarProducto(@Validated @RequestBody Cliente cliente) {
				
		Optional<Cliente> clienteResponse = clienteService.registrarCliente(cliente);

		if (clienteResponse.isPresent()) {
			log.debug("Registro creado correctamente");
			return ResponseEntity.ok(clienteResponse);
		}

		ResponseDTO response = new ResponseDTO();
		response.setHttpStatus(HttpStatus.NO_CONTENT.value());
		response.setMessage("Registro no creado en la BD");
		response.setCode(Constantes.CODIGO_ERROR_001);
		response.setBackendMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
		
		log.error(response.toString());

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseDTO> handleMyException(HttpServletRequest req, DataIntegrityViolationException ex) {
		ResponseDTO response = new ResponseDTO();
		response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage("Registro no creado en la BD");
		response.setCode(Constantes.CODIGO_ERROR_001);
		response.setBackendMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		log.error(response.toString());
        return ResponseEntity.ok(response);
    }

}
