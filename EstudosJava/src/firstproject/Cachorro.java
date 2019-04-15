package firstproject;

public class Cachorro extends Animal{

	public Cachorro(String nome) {
		super(nome);
	}

	@Override
	public void makeNoise() {
		System.out.println("Bark..");
	}

}
