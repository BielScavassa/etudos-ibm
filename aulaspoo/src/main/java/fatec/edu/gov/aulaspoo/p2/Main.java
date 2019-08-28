package fatec.edu.gov.aulaspoo.p2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Turmas turma01 = new Turmas("Jogos Digitais", 55, new ArrayList<Aluno>());
		Aluno jose = new Aluno(1, "Jose", 0.0, 0);
		Aluno rose = new Aluno(2, "Rose", 0.0, 0);

		turma01.matricularAluno(jose);
		turma01.matricularAluno(rose);

		turma01.buscarAluno(1);
		turma01.buscarAluno(2);

		turma01.registrarFalta(1);
		turma01.registrarFalta(2);

		turma01.atribuirNota(1, 7.0);
		turma01.atribuirNota(2, 5.0);

		turma01.listarTodos();

		turma01.listarAprovados();

	}

}
