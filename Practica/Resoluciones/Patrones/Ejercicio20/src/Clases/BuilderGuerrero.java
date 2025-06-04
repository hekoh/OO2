package Clases;

public class BuilderGuerrero extends BuilderPersonaje{
	private Personaje pj;
	
	
	public BuilderGuerrero() {
		this.pj = new Personaje();
	}
	
	
	public void setArma() {
		pj.setArma(new Espada());
	}
	
	public void setArmadura() {
		pj.setArmadura(new Acero());
	}
	
	public void setHabilidad() {
		pj.setHabilidad("Combate cuerpo a cuerpo");
	}
	
	public void setNombre(String nombre) {
		pj.setNombre(nombre);
	}
	
	public Personaje getResultado() {
		return pj;
	}
	
}
