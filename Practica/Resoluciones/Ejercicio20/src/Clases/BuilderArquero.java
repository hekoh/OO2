package Clases;

public class BuilderArquero extends BuilderPersonaje{
	private Personaje pj;
	
	
	public BuilderArquero() {
		this.pj = new Personaje();
	}
	
	public void setArma() {
		pj.setArma(new Arco());
	}
	
	public void setArmadura() {
		pj.setArmadura(new Cuero());
	}
	
	public void setHabilidad() {
		pj.setHabilidad("Combate a distancia");
	}
	
	public void setNombre(String nombre) {
		pj.setNombre(nombre);
	}
	
	public Personaje getResultado() {
		return pj;
	}
	
}
