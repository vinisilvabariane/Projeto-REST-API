package com.servidor.model;
import javax.persistence.*;

@Entity
public class Computadores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", nullable = false, unique=true)
	private String nome;
	
	@Column(name="marca", nullable = false)
	private String marca;
	
	@Column(name="processador", nullable = false)
	private String processador;
	
	@Column(name="armazenamento", nullable = false)
	private String armazenamento;
	
	@Column(name="ram", nullable = false)
	private String ram;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}
	
	
}
