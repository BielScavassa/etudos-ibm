package firstproject;

public class Pizza {
	private String sabor;
	private int tamanho;
	private String borda;
	private TipoMassa tipoMassa;
	
	public Pizza() {
	}

	public Pizza(String sabor, int tamanho, String borda, TipoMassa tipoMassa) {
		this.sabor = sabor;
		this.tamanho = tamanho;
		this.borda = borda;
		this.tipoMassa = tipoMassa;
	}

	public void assar() {
		System.out.println("Assando a pizza sabor" + this.sabor);
	}
	
	public void show(String sabor, int tamanho) {
		System.out.println("Sabor: " + sabor + "Tamanho: " + tamanho);
	}
	
	public void show(String borda, TipoMassa tipoMassa) {
		System.out.println("Borda: " + borda + "Tipo da massa: " + tipoMassa);
	}
	
	public String getSabor() {
		return sabor;
	}


	public void setSabor(String sabor) {
		this.sabor = sabor;
	}


	public int getTamanho() {
		return tamanho;
	}


	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}


	public String getBorda() {
		return borda;
	}


	public void setBorda(String borda) {
		this.borda = borda;
	}


	public TipoMassa getTipoMassa() {
		return tipoMassa;
	}


	public void setTipoMassa(TipoMassa tipoMassa) {
		this.tipoMassa = tipoMassa;
	}
	
	@Override
	public String toString() {
		return "Pizza [sabor=" + sabor + ", tamanho=" + tamanho + ", borda=" + borda + ", tipoMassa=" + tipoMassa + "]";
	}
}
