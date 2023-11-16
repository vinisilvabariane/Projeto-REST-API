package com.servidor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.servidor.error.ResourceNotFoundException;
import com.servidor.model.Computadores;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<Optional<Computadores>> getComputador(@PathVariable @Valid Long id) throws ResourceNotFoundException{
		
		this.verifyIfComponentExists(id);
	
		List<Optional<Computadores>> list = new ArrayList<Optional<Computadores>>();
		Optional<Computadores> computador = computadoresRepository.findById(id);
		
		list.add(computador);
		
		return list;
}
	
	@PostMapping("/computadores")
public ResponseEntity<String> adicionarComputador(@RequestBody @Valid Computadores computador) {
		
		if(computador == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		 computador.setId(null);
		
		try {
			 computadoresRepository.save(computador);}
		catch(org.springframework.dao.DataIntegrityViolationException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/computadores/{id}")
	public ResponseEntity<?> deletarComputador(@PathVariable @Valid Long id) throws ResourceNotFoundException {

		this.verifyIfComponentExists(id);
		
		computadoresRepository.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/computadores/{id}")
	public ResponseEntity<?> alterarComponente(@RequestBody @Valid Computadores computador) throws ResourceNotFoundException {
		
		this.verifyIfComponentExists(computador.getId());
		
		computadoresRepository.save(computador);
		return new ResponseEntity<>(HttpStatus.CREATED);
	
	}
	
	public void verifyIfComponentExists(Long id) throws ResourceNotFoundException {
		if(computadoresRepository.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Computador com id " +id + " não encontrado");
		};
}}

