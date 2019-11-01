package com.ibm.specification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCriteria {

	private String nome;
	private String sobrenome;
	private String email;
	private Integer idade;
	private Integer idadeMinima;
	private Integer idadeMaxima;
	
}
