package com.servidor.controller;

import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.servidor.model.Componentes;
import com.servidor.repository.ComponentesRepository;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.dao.EmptyResultDataAccessException;

@RestController
public class ComponentesController {
	
	@Autowired
	private ComponentesRepository componentesRepository;
	
	@GetMapping("/componentes")
	public List<Componentes> getComponentes() {
			return componentesRepository.findAll();
	}
	
	@GetMapping("/componentes/{id}")
	public List<Optional<Componentes>> getComponente(@PathVariable Long id) {
			List<Optional<Componentes>> list = new ArrayList<Optional<Componentes>>();
			Optional<Componentes> cliente = componentesRepository.findById(id);
			list.add(cliente);
			return list;
	}
	
	@PostMapping("/componentes")
	public HttpStatus adicionarComponente(@RequestBody Componentes cliente) {
		try {
			componentesRepository.save(cliente);}
		catch(org.hibernate.exception.ConstraintViolationException e) {
			return HttpStatus.CONFLICT;
		}
		return HttpStatus.CREATED;
	}
	
	@DeleteMapping("/componentes/{id}")
	public HttpStatus deletarComponente(@PathVariable Long id) {
		try {
			componentesRepository.deleteById(id);
			return HttpStatus.ACCEPTED;}
		catch(EmptyResultDataAccessException e) {
			return HttpStatus.BAD_REQUEST;
		}
	}
	
	@PutMapping("/componentes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public HttpStatus alterarComponente(@PathVariable Long id,@RequestBody Componentes componente) {
		
		try {
			componentesRepository.deleteById(id);}
		catch(EmptyResultDataAccessException e) {
			return HttpStatus.BAD_REQUEST;
		}
		
		componente.setId(id);
		componentesRepository.save(componente);
		return HttpStatus.ACCEPTED;
	}
	
}