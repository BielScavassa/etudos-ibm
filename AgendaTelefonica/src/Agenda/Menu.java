package Agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	final static Scanner scanner = new Scanner(System.in);
	static List<Contato> listaContatos = new ArrayList<Contato>();

	public static void main(String[] args) {		
		int opcaoSelecionada = 0;
		
		do {
			System.out.println("Menu: \n"
					+ "1 - Consultar cotato. \n"
					+ "2 - Adicionar contato. \n"
					+ "3 - Remover Contato \n"
					+ "4 - Sair.");
			
			opcaoSelecionada = scanner.nextInt();
		
			switch(opcaoSelecionada) {
				case 1:
					consultarContato();
					break;
				case 2:
					adicionarContato();
					break;				
				case 3:
					removerContato();
					break;
				case 4:
					System.out.println("Bye Bye.");
					break;
				default:
					System.out.println("Digite uma opção válida.");
			}
		
		}while(opcaoSelecionada < 4 && opcaoSelecionada > 0);
	
	}
	
	
	public static void adicionarContato() {
		int adicionarOutroTelefone = 0;
		int adicionarOutroContato = 0;
		int menuOuUsuario = 0;
		
		do {
		Contato contato = new Contato();
			System.out.println("Insira o ID:");
			contato.setId(scanner.nextInt());
			System.out.println("Insira o nome:");
			contato.setNome(scanner.next());
			
			do {
				Telefone telefone = new Telefone();
				
				System.out.println("Insira o ddd:");
				telefone.setDdd(scanner.nextShort());
				
				System.out.println("Insira o numero:");
				telefone.setNumero(scanner.next());
				
				System.out.println("Insira o tipo de telefone:");
				telefone.setTipoTelefone(scanner.next());		
				
				contato.getTelefones().add(telefone);
				System.out.println("Telefone Adicionado com sucesso!");
				
				System.out.println("Você deseja adicionar outro telefone? [1]-Sim, [2]-Não");
				adicionarOutroTelefone = scanner.nextInt();
				
				if(adicionarOutroTelefone == 2){
					System.out.println("[1]-Você deseja continuar adicionando outros contatos ou [2]-Voltar ao menu");
					menuOuUsuario = scanner.nextInt();
				}		
			}while(adicionarOutroTelefone != 2);
			
			listaContatos.add(contato);
			System.out.println("Contato adicionado com sucesso \n");
			
			if(menuOuUsuario == 2) break;
			
		}while(adicionarOutroContato != 2);
		
	}
	
	public static void consultarContato() {
		int idContato, voltarMenu;

		if (listaContatos.isEmpty()) {
			System.out.println("Você não tem contatos na sua lista. \n");
			return;
		}
		
		for (Contato contato : listaContatos) {			
			System.out.println("ID: " + contato.getId());
			System.out.println("Nome: " + contato.getNome() + "\n");
		}
		System.out.println("Insira o ID do contato:");
		idContato = scanner.nextInt();
		
		for(Contato contato : listaContatos) {
			if(contato.getId() == idContato) {
				System.out.println("Nome:" + contato.getNome() + "\n");
				for (Telefone telefone : contato.getTelefones()) {
					System.out.println("Tipo:" + telefone.getTipoTelefone() + "\n");
					System.out.println("Ddd:" + telefone.getDdd() + "\n");
					System.out.println("Numero:" + telefone.getNumero());
				}
			}				
		}
		do {
			System.out.println("Pressione-[1] para voltar ao menu:");
			voltarMenu = scanner.nextInt();
		}while(voltarMenu != 1);
	}
	
	public static void removerContato() {
		int idContato, confirmarRemover;
		
		for (Contato contato : listaContatos) {
			System.out.println("ID: " + contato.getId());
			System.out.println("Nome: " + contato.getNome() + "\n");
		}
		
		do {
			if (listaContatos.isEmpty()) {
				System.out.println("Você não tem contatos na sua lista. \n");
				break;
			}
			
			System.out.println("Você deseja remover algum de seus contatos? [1]-Sim [2]-Não");
			confirmarRemover = scanner.nextInt();
			
			if(confirmarRemover == 2) break;
			
			System.out.println("Insira o ID do contato que deseja remover:");
			idContato = scanner.nextInt();
			
			for (Contato countContato : listaContatos) {
				if(countContato.getId() == idContato) {
					System.out.println("Contato localizado. \n");
				}else {
					System.out.println("Contato não cadastrado. \n");
					return;
				}
			}
			
			System.out.println("Você tem certeza que deseja remover este contato? [1]-Sim [2]-Não");
			confirmarRemover = scanner.nextInt();
			
			if(confirmarRemover == 2) break;
			
			for (Contato contato : listaContatos) {
				if(contato.getId() == idContato) {
					listaContatos.remove(contato);
					System.out.println("Contato removido.");
					break;
				}
			}
		}while(confirmarRemover != 1);
	}

}
