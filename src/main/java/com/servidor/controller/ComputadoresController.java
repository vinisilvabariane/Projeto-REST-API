package com.servidor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
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
    public ResponseEntity<List<Computadores>> getComputadores() {
        return ResponseEntity.ok(computadoresRepository.findAll());
    }
    
    @GetMapping("/computadores/{id}")
    public ResponseEntity<Computadores> getComputador(@PathVariable @Valid Long id) 
            throws ResourceNotFoundException {
        
        Computadores computador = computadoresRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Computer with id " + id + " not found"));
        
        return ResponseEntity.ok(computador);
    }
    
    @PostMapping("/computadores")
    public ResponseEntity<Computadores> adicionarComputador(@RequestBody @Valid Computadores computador) {
        Computadores savedComputador = computadoresRepository.save(computador);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComputador);
    }

    @DeleteMapping("/computadores/{id}")
    public ResponseEntity<Void> deletarComputador(@PathVariable @Valid Long id) 
            throws ResourceNotFoundException {
        
        verifyIfComputerExists(id);
        computadoresRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/computadores/{id}")
    public ResponseEntity<Computadores> alterarComputador(
            @PathVariable Long id,
            @RequestBody @Valid Computadores computador) 
            throws ResourceNotFoundException {
        
        verifyIfComputerExists(id);
        computador.setId(id); // Ensure ID matches path
        Computadores updatedComputador = computadoresRepository.save(computador);
        return ResponseEntity.ok(updatedComputador);
    }
    
    private void verifyIfComputerExists(Long id) throws ResourceNotFoundException {
        if(!computadoresRepository.existsById(id)) {
            throw new ResourceNotFoundException("Computer with id " + id + " not found");
        }
    }
}