package br.com.victor.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="TB_USER")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_Sequence")
	@SequenceGenerator(name = "client_Sequence", sequenceName = "CLIENT_SEQ")
	private long id;

	
	@Column(name = "name")
	@NotNull(message = "Name cannot be null!")
	@Size(min = 3, max = 80, message = "Name Me must be between 3 and 80 characters")
	private String name;

	@Column(name = "lastname")
	@NotNull(message = "Lastname cannot be null!")
	@Size(min = 3, max = 80, message = "Name Me must be between 3 and 80 characters")
	private String lastname;

	@Column(name = "username")
	@NotNull(message = "Lastname cannot be null!")
	@Size(min = 3, max = 80, message = "LastName Me must be between 3 and 80 characters")
	@Email
	private String username;

	@Lob
	@Column(name = "password")
	@NotNull(message = "Password cannot be null!")
	@JsonIgnore
	private String password;
	
	@Lob
	@Column(name = "publickey")
	@JsonIgnore
	private String publicKey;

	
	@Column(name = "cpf")
	@Size(max = 14, message = "cpf need 14 characters")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@Column(name = "cellphone")
	private String cellphone;

	@Column(name = "birthdate")
	private LocalDate birthdate;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}


}
