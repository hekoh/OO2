package Clases;

public abstract class Empleados {
	private String nombre;
	private double sueldoBasico;
	
	public Empleados(String nombre, double sueldo) {
		this.nombre = nombre;
		this.sueldoBasico = sueldo;
	}
	
	public double sueldo() {
		return this.sueldoBasico;
	}
	
	public double descuento(double basico, double adicional) {		//template method
		return (basico*0.13 + adicional*0.05);
	}
	
}
