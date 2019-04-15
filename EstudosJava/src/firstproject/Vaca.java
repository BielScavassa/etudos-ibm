package firstproject;

public class Vaca extends Animal{

	public Vaca(String nome) {
		super(nome);
	}

	@Override
	public void makeNoise() {
		System.out.println("Muuu...");
	}

}
