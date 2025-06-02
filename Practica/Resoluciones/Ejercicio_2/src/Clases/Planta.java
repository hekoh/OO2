package Clases;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;


public final class Planta extends Empleados{
	private LocalDate inicio;
	private int hijos;
	private boolean casado;
	
	
	public Planta(String nombre, LocalDate inicio, int hijos, boolean casado) {
		super(nombre,50000.0);
		this.inicio = inicio;
		this.hijos = hijos;
		this.casado = casado;
	}
	
	public double sueldo() {
		double basico = super.sueldo();
		double extra = this.adicional();
		return (basico + extra - super.descuento(basico, extra));
	}
	
	private double adicional() {
		double total = (casado == true)? 5000 : 0;
		total+= 2000*hijos;
		total+= ChronoUnit.YEARS.between(inicio, LocalDate.now())*2000;
		return total;
	}
}

