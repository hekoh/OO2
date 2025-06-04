package Clases;

public class Topografia {
	private Composicion composicion;
	
	
	public void añadirComposicion(Composicion comp) {
		this.composicion = comp;
	}
	
	public Composicion getComposicion() {
		return this.composicion;
	}
	
	public double proporcionAgua() {
		return this.composicion.proporcionAgua();
	}
	
	@Override
	public boolean equals(Object topo) {
		return (topo.getClass() == Topografia.class)? this.composicion.equals(((Topografia)topo).getComposicion()) : false;
	}
}
