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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import com.servidor.error.ResourceNotFoundException;

@RestController
@Validated
public class ComponentesController {
	
	@Autowired
	private ComponentesRepository componentesRepository;
	
	@GetMapping("/componentes")
	public List<Componentes> getComponentes() {
			return componentesRepository.findAll();
	}
	
	@GetMapping("/componentes/{id}")
	public List<Optional<Componentes>> getComponente(@PathVariable @Valid Long id) throws ResourceNotFoundException{
			
			this.verifyIfComponentExists(id);
		
			List<Optional<Componentes>> list = new ArrayList<Optional<Componentes>>();
			Optional<Componentes> componente = componentesRepository.findById(id);
			
			list.add(componente);
			
			return list;
	}
	
	@PostMapping("/componentes")
	public ResponseEntity<String> adicionarComponente(@RequestBody @Valid Componentes componente) {
		
		if(componente == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		componente.setId(null);
		
		try {
			componentesRepository.save(componente);}
		catch(org.springframework.dao.DataIntegrityViolationException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/componentes/{id}")
	public ResponseEntity<?> deletarComponente(@PathVariable @Valid Long id) throws ResourceNotFoundException {

		this.verifyIfComponentExists(id);
		
		componentesRepository.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/componentes")
	public ResponseEntity<?> alterarComponente(@RequestBody @Valid Componentes componente) throws ResourceNotFoundException {
		
		this.verifyIfComponentExists(componente.getId());
		
		componentesRepository.save(componente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	
	}
	
	public void verifyIfComponentExists(Long id) throws ResourceNotFoundException {
		if(componentesRepository.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Componente com id " +id + " não encontrado");
		};
	}
	
}