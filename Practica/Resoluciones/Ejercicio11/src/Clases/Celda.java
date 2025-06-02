package Clases;

public class Celda implements Composicion{
	private double proporcion;
	
	public Celda(double prop) {
		this.proporcion = prop;
	}
	
	public double proporcionAgua() {
		return this.proporcion;
	}
	
	@Override
	public boolean equals(Object celda) {
		 return (celda.getClass() == Celda.class)? this.proporcion == ((Celda)celda).proporcionAgua() : false;
	}
}
