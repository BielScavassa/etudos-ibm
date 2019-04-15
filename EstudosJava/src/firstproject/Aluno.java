package firstproject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Aluno extends Pessoa{
	
	private String ra;
	private LocalDateTime dataHoraMatricula;

	public Aluno(String nome, LocalDate dataNascimento, String cpf, String ra, LocalDateTime dataHoraMatricula) {
		super(nome, dataNascimento, cpf);
		
		this.ra = ra;
		this.dataHoraMatricula = dataHoraMatricula;
	}
	
	public int idade() {
		LocalDate now = LocalDate.now();
		long age = ChronoUnit.YEARS.between(super.getDataNascimento(), now);
				
		return (int) age;
	}
	
	public int ano() {
		return this.dataHoraMatricula.getYear();
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public LocalDateTime getDataHoraMatricula() {
		return dataHoraMatricula;
	}

	public void setDataHoraMatricula(LocalDateTime dataHoraMatricula) {
		this.dataHoraMatricula = dataHoraMatricula;
	}

	@Override
	public String toString() {
		return super.toString() + "Aluno [ra=" + ra + ", dataHoraMatricula=" + dataHoraMatricula + "]";
	}
	
	
}
