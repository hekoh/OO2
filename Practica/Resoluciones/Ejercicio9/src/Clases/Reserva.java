package Clases;

import java.time.LocalDate;

public class Reserva {
	private int cantDias;
	private LocalDate fecha;
	private AutoEnAlquiler auto;
	private Usuario conductor;
	
	
	public Reserva(int dias, LocalDate fecha, AutoEnAlquiler auto,Usuario conductor) {
		this.cantDias = dias;
		this.fecha = fecha;
		this.auto = auto;
		this.conductor = conductor;
	}
	
	public double montoAPagar() {
		return this.auto.PrecioTotal(cantDias);
	}
	
	public double montoAReembolsar() {
		return this.auto.devolucion(cantDias, fecha);
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
}
