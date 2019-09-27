package fatec.edu.gov.aulaspoo;

import fatec.edu.gov.aulaspoo.desafio.Carro;
import fatec.edu.gov.aulaspoo.desafio.Cliente;
import fatec.edu.gov.aulaspoo.desafio.Funcionario;

public class Main {
	public static void main(String[] args) {

		//Prestar atenção nos valores atribuidos aos objetos para nao passar valore negativos
		
		//Desafio 1
		Carro uno = new Carro("Uno", 2009, "sei la", 100.00);
		Cliente gabriel = new Cliente("Bobão", "63728927", 500.00, null);
		Funcionario perrotti = new Funcionario(283928L, "Perroti", 0.00, 10.00, 0);
		
		//Desafio 2
		System.out.println("Desafio 2 :");
		System.out.println(gabriel + "\n" + uno + "\n" + perrotti);
		System.out.println("\n");
		
		//Desafio 6
		System.out.println("Desafio 6 :");
		gabriel.alugarCarro(uno);
		System.out.println( gabriel);
		System.out.println("\n");
		
		//Desafio 7
		System.out.println("Desafio 7 :");
		System.out.println(gabriel.devolverCarro());
		System.out.println(gabriel);
		System.out.println("\n");
		
		//Desafio 8
		System.out.println("Desafio 8 :");
		System.out.println(gabriel.alugarCarroAprimorado(uno, perrotti));
		System.out.println(gabriel + "\n" + perrotti);
		System.out.println("\n");
		
		//Desafio 9
		System.out.println("Desafio 9 :");
		System.out.println(gabriel.comprarCarro(uno, perrotti));
		System.out.println(gabriel + "\n" + perrotti + "\n" + uno);
		
	}
}
