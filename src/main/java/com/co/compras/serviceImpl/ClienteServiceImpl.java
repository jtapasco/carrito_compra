package com.co.compras.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.compras.entity.Cliente;
import com.co.compras.repository.ClienteRepository;
import com.co.compras.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	
	@Autowired 
	ClienteRepository clienteRepository;
	
	@Override
	public Optional<Cliente> registrarCliente(Cliente cliente) {
		
		return Optional.of(clienteRepository.save(cliente));
	}

}
