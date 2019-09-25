package com.ibm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String endereco;
	
	@Autowired
	public ClienteModel(Long id, String nome, String endereco) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}

	
	
}
