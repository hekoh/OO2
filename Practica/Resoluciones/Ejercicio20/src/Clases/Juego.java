package Clases;

public class Juego {
	BuilderPersonaje builder;
	
	
	public Juego(BuilderPersonaje builder) {
		this.builder = builder;
	}
	
	public void setBuilder(BuilderPersonaje builder) {
		this.builder = builder;
	}
	
	public Personaje buildPersonaje(String nombre) {
		builder.setArma();
		builder.setArmadura();
		builder.setHabilidad();
		builder.setNombre(nombre);
		return builder.getResultado();
	}
}
