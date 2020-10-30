package com.co.compras.service;

import java.util.Optional;

import com.co.compras.entity.Cliente;

public interface IClienteService {


	public Optional<Cliente> registrarCliente(Cliente cliente);
	
}
