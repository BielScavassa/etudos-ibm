package Agenda;

public class Telefone {
	private short ddd;
	private String numero, tipoTelefone;

	public short getDdd() {
		return ddd;
	}

	public void setDdd(short newDdd) {
		this.ddd = newDdd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String newNumero) {
		this.numero = newNumero;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String newTipoTelefone) {
		this.tipoTelefone = newTipoTelefone;
	}
}
