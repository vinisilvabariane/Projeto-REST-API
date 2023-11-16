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
import com.servidor.model.Computadores;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.dao.EmptyResultDataAccessException;
import com.servidor.repository.ComputadoresRepository;

@RestController
public class ComputadoresController {
	
	@Autowired
	private ComputadoresRepository computadoresRepository;
	
	@GetMapping("/computadores")
	public List<Computadores> getComputadores() {
			return computadoresRepository.findAll();
	}
	
	@GetMapping("/computadores/{id}")
	public List<Optional<Computadores>> getComputador(@PathVariable Long id) {
			List<Optional<Computadores>> list = new ArrayList<Optional<Computadores>>();
			Optional<Computadores> cliente = computadoresRepository.findById(id);
			list.add(cliente);
			return list;
	}
	
	@PostMapping("/computadores")
	public HttpStatus adicionarComponente(@RequestBody Computadores cliente){
		try {
			computadoresRepository.save(cliente);}
		catch(org.hibernate.exception.ConstraintViolationException e) {
			return HttpStatus.CONFLICT;
		}
		return HttpStatus.CREATED;
	}
	
	@DeleteMapping("/computadores/{id}")
	public HttpStatus deletarComputador(@PathVariable Long id) {
		try {
			computadoresRepository.deleteById(id);
			return HttpStatus.ACCEPTED;}
		catch(EmptyResultDataAccessException e) {
			return HttpStatus.BAD_REQUEST;
		}
	}
	
	@PutMapping("/computadores/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public HttpStatus alterarComputador(@PathVariable Long id,@RequestBody Computadores cliente) {
		try {
			computadoresRepository.deleteById(id);}
		catch(EmptyResultDataAccessException e) {
			return HttpStatus.BAD_REQUEST;
		}
		cliente.setId(id);
		computadoresRepository.save(cliente);
		return HttpStatus.ACCEPTED;
	}
	
}

