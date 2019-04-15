package com.ibm.biblioteca.emprestimo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ibm.biblioteca.usuario.model.UsuarioModel;

@Entity
public class EmprestimoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date dataInicio;
	private Date datafim;
	@ManyToOne 
	private UsuarioModel usuario;
	
	public EmprestimoModel(long id, Date dataInicio, Date datafim) {
		this.id = id;
		this.dataInicio = dataInicio;
		this.datafim = datafim;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDatafim() {
		return datafim;
	}
	public void setDatafim(Date datafim) {
		this.datafim = datafim;
	}
	
}
