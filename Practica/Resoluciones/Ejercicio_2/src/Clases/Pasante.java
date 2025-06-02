package Clases;

public class Pasante extends Empleados{
	private int examenes;
	
	public Pasante(String nombre, int examenes) {
		super(nombre,20000.0);
		this.examenes = examenes;
	}
	
	public double sueldo() {
		double basico = super.sueldo();
		double extra = this.adicional();
		return (basico + extra - super.descuento(basico, extra));
	}
	
	private double adicional() {
		return 2000*examenes;
	}
	
	
	
}
