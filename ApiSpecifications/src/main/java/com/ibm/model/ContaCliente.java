package com.ibm.model;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class ContaCliente implements Serializable {

	@EmbeddedId
	private IdContaCliente contaCliente;
	private String nome;
	private String cpf;
	private Integer idade;
	private Double saldoConta;

	@Autowired
	public ContaCliente(IdContaCliente contaCliente, String cpf, String nome, Integer idade, Double saldoConta) {
		this.contaCliente = contaCliente;
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.saldoConta = saldoConta;
	}
}
