package Clases;

public class Cadena {
	private Builder builder;
	
	
	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	
	public void crearSandwitch() {
		this.builder.crearSandwich();
	}
	
	public Sandwich obtenerSandwich() {
		return this.builder.obtenerResultado();
	}
	
}
