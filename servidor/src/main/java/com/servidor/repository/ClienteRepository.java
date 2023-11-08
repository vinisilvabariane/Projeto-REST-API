package com.servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servidor.model.Clientes;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes,Long>{
	
}
