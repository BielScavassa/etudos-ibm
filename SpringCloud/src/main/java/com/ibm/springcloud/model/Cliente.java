package com.ibm.springcloud.model;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente {

	private String nome;
	private String endereco;

	@Autowired
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

}
