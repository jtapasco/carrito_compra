package com.co.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.compras.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
