package com.servidor.controller;

import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.servidor.model.Clientes;
import com.servidor.repository.ClienteRepository;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.dao.EmptyResultDataAccessException;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Clientes> getClientes() {
			return clienteRepository.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public List<Optional<Clientes>> getCliente(@PathVariable Long id) {
			List<Optional<Clientes>> list = new ArrayList();
			Optional<Clientes> cliente = clienteRepository.findById(id);
			list.add(cliente);
			return list;
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Clientes adicionarCliente(@RequestBody Clientes cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/clientes/{id}")
	public HttpStatus deletarCliente(@PathVariable Long id) {
		try {
			clienteRepository.deleteById(id);
			return HttpStatus.ACCEPTED;}
		catch(EmptyResultDataAccessException e) {
			return HttpStatus.BAD_REQUEST;
		}
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public HttpStatus alterarCliente(@PathVariable Long id,@RequestBody Clientes cliente) {
		try {
			clienteRepository.deleteById(id);}
			catch(EmptyResultDataAccessException e) {
			return HttpStatus.BAD_REQUEST;
		}
		cliente.setId(id);
		clienteRepository.save(cliente);
		return HttpStatus.ACCEPTED;
	}
	
}