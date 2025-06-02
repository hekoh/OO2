package Clases;

import java.util.stream.Stream;

public class Temporario extends Empleados {
	private int horas;
	private int hijos;
	private boolean casado;
	
	
	public Temporario(String nombre, int horas, int hijos, boolean casado) {
		super(nombre,20000.0);
		this.horas = horas;
		this.hijos = hijos;
		this.casado = casado;
	}
	
	@Override
	public double sueldo() {
		double basico = super.sueldo() + (horas*300);
		double extra = this.adicional();
		return (basico + extra - super.descuento(basico, extra));
	}
	
	
	private double adicional() {
		double total = (casado == true)? 5000 : 0;
		total+= 2000*hijos;
		return total;
	}
	
	
}
