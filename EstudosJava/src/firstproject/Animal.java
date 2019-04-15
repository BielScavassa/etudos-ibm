package firstproject;

public abstract class Animal {
	
	private String nome;
	
	public abstract void makeNoise();
	
	public Animal(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
