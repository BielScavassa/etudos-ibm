package firstproject;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EscolaMain {
	
	public static void main(String[] args) {
		Aluno aluno = new Aluno("Jozé", LocalDate.of(1997, 05, 15), "123.123.123-66", "0030293102843", LocalDateTime.now());
		
		AlunoInterface alunoInter = new AlunoInterfaceImpl();
		alunoInter.age(LocalDate.of(1997, 05, 15));
		
		System.out.println(alunoInter);
				
		System.out.println(aluno);
		System.out.println("Idade: " + aluno.idade());
		System.out.println("Ano matricula: " + aluno.ano());
	}
}
