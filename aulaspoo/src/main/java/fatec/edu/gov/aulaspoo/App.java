package fatec.edu.gov.aulaspoo;

import fatec.edu.gov.aulaspoo.desafio.Carro;
import fatec.edu.gov.aulaspoo.desafio.Cliente;
import fatec.edu.gov.aulaspoo.desafio.Funcionario;

public class App {
	public static void main(String[] args) {

		Carro uno = new Carro("Uno", 2009, "sei la", 100.00);

		Cliente gabriel = new Cliente("Bobão", "63728927", 500.00, null);

		Funcionario perrotti = new Funcionario(283928L, "Perroti", 0.00, 10.00, 0);

		System.out.println(gabriel.comprarCarro(uno, perrotti));
		System.out.println("Cliente: " + gabriel + "\n" + "Carro: " + uno + "\n" + "Funcionário: " + perrotti);

	}
}
