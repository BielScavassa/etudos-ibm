package firstproject;

public class PizzaMain {

	public static void main(String[] args) {
		
		Pizza makeYourPizza = new Pizza();
		Pizza marguerita = new Pizza("Marguerita", 40, "Cheddar", TipoMassa.TRADICIONAL);
		
		System.out.println(marguerita);
		marguerita.assar();
		System.out.println();
		
		makeYourPizza.setSabor("4 Queijos");
		makeYourPizza.setTamanho(60);
		makeYourPizza.setBorda("Cheddar");
		makeYourPizza.setTipoMassa(TipoMassa.TRADICIONAL);
		
		makeYourPizza.show(makeYourPizza.getSabor(), makeYourPizza.getTamanho());
		makeYourPizza.show(makeYourPizza.getBorda(), makeYourPizza.getTipoMassa());
		System.out.println(makeYourPizza);
		System.out.println();
		makeYourPizza.assar();
		
	}

}
