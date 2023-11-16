package com.servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servidor.model.Componentes;

@Repository
public interface ComponentesRepository extends JpaRepository<Componentes,Long>{
	
}
