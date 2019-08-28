package fatec.edu.gov.aulaspoo.p2;

public class Aluno {

	private Integer codigoDoAluno;

	private String nomeAluno;

	private Double mediaFinal;

	private Integer quantidadeDeFaltas;

	public Aluno(Integer codigoDoAluno, String nomeAluno, Double mediaFinal, Integer quantidadeDeFaltas) {
		this.codigoDoAluno = codigoDoAluno;
		this.nomeAluno = nomeAluno;
		this.mediaFinal = mediaFinal;
		this.quantidadeDeFaltas = quantidadeDeFaltas;
	}

	public Integer getCodigoDoAluno() {
		return codigoDoAluno;
	}

	public void setCodigoDoAluno(Integer codigoDoAluno) {
		this.codigoDoAluno = codigoDoAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Double getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(Double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}

	public Integer getQuantidadeDeFaltas() {
		return quantidadeDeFaltas;
	}

	public void setQuantidadeDeFaltas(Integer quantidadeDeFaltas) {
		this.quantidadeDeFaltas = quantidadeDeFaltas;
	}

	@Override
	public String toString() {
		return "Aluno [codigoDoAluno=" + codigoDoAluno + ", nomeAluno=" + nomeAluno + ", mediaFinal=" + mediaFinal
				+ ", quantidadeDeFaltas=" + quantidadeDeFaltas + "]";
	}

}
