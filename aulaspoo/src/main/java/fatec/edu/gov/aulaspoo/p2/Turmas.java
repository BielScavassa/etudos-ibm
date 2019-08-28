package fatec.edu.gov.aulaspoo.p2;

import java.util.ArrayList;
import java.util.List;

public class Turmas {

	private String nomeDoCurso;

	private Integer quantidadeTotalDeAulas;

	private List<Aluno> listaDeAlunos = new ArrayList<Aluno>();

	public Turmas(String nomeDoCurso, Integer quantidadeTotalDeAulas, List<Aluno> listaDeAlunos) {
		this.nomeDoCurso = nomeDoCurso;
		this.quantidadeTotalDeAulas = quantidadeTotalDeAulas;
		this.listaDeAlunos = listaDeAlunos;
	}

	public Boolean matricularAluno(Aluno al) {
		if (listaDeAlunos.size() > 20) {
			System.out.println("false");
			return false;
		}

		for (Aluno aluno : listaDeAlunos) {
			if (aluno.getCodigoDoAluno() == al.getCodigoDoAluno()) {
				System.out.println("false");
				return false;
			}
		}

		al.setQuantidadeDeFaltas(0);
		al.setMediaFinal(0.0);

		listaDeAlunos.add(al);
		System.out.println("Adicionado com sucesso");
		return true;
	}

	public Integer buscarAluno(Integer codigo) {
		Integer indexAluno = -1;

		if (!listaDeAlunos.isEmpty()) {

			for (Aluno aluno : listaDeAlunos) {
				if (aluno.getCodigoDoAluno() == codigo) {
					indexAluno = listaDeAlunos.indexOf(aluno);
					break;
				} else {
					indexAluno = -1;
				}
			}
		}
		System.out.println(indexAluno);
		return indexAluno;
	}

	public Boolean registrarFalta(Integer codigo) {
		Boolean faltaDoAluno = false;

		if (!listaDeAlunos.isEmpty()) {
			for (Aluno aluno : listaDeAlunos) {
				Integer faltas = aluno.getQuantidadeDeFaltas();

				if (aluno.getCodigoDoAluno() == codigo) {
					aluno.setQuantidadeDeFaltas(faltas + 1);
					faltaDoAluno = true;
					break;
				} else {
					faltaDoAluno = false;
				}
			}
		}
		System.out.println(faltaDoAluno);
		return faltaDoAluno;
	}

	public Boolean atribuirNota(Integer codigo, Double media) {
		Boolean notaDoAlunoAtribuida = false;

		if (!listaDeAlunos.isEmpty()) {
			if (media < 0 || media > 10) {
				System.out.println("A m�dia precisa ser um numero entre 0 e 10.");
				return false;
			}

			for (Aluno aluno : listaDeAlunos) {
				if (aluno.getCodigoDoAluno() == codigo) {
					aluno.setMediaFinal(media);
					notaDoAlunoAtribuida = true;
					break;
				} else {
					notaDoAlunoAtribuida = false;
				}
			}

		}
		System.out.println(notaDoAlunoAtribuida);
		return notaDoAlunoAtribuida;
	}

	public void listarTodos() {
		System.out.println(getNomeDoCurso());
		for (Aluno aluno : listaDeAlunos) {
			System.out.println(aluno.toString());
		}
	}

	public void listarAprovados() {
		System.out.println(getNomeDoCurso());
		for (Aluno aluno : listaDeAlunos) {
			if (aluno.getMediaFinal() >= 6.0)
				System.out.println(aluno.toString());
		}
	}

	public String getNomeDoCurso() {
		return nomeDoCurso;
	}

	public void setNomeDoCurso(String nomeDoCurso) {
		this.nomeDoCurso = nomeDoCurso;
	}

	public Integer getQuantidadeTotalDeAulas() {
		return quantidadeTotalDeAulas;
	}

	public void setQuantidadeTotalDeAulas(Integer quantidadeTotalDeAulas) {
		this.quantidadeTotalDeAulas = quantidadeTotalDeAulas;
	}

	public List<Aluno> getListaDeAlunos() {
		return listaDeAlunos;
	}

	public void setListaDeAlunos(List<Aluno> listaDeAlunos) {
		this.listaDeAlunos = listaDeAlunos;
	}
}
