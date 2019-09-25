package fatec.edu.gov.aulaspoo.desafio;

public class Gerente extends Funcionario {
	private String loja;
	Funcionario funcionario;

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Gerente(Long id, String nome, Double comissao, Double salario, Integer qtdVendas, String loja,
			Funcionario funcionario) {
		super(id, nome, comissao, salario, qtdVendas);
		this.loja = loja;
		this.funcionario = funcionario;
	}

}
