package Clases;

import java.time.LocalDate;



public class AutoEnAlquiler {
	private double precioPorDia;
	private int cantidadPlazas;
	private String marca;
	private PoliticaDevolucion politica;
	
	public AutoEnAlquiler(double precio, int plazas, String marca, PoliticaDevolucion pol) {
		this.precioPorDia = precio;
		this.cantidadPlazas = plazas;
		this.marca = marca;
		this.politica = pol;
	}
	
	public double devolucion(int dias, LocalDate fecha) {
		return this.politica.devolucion(dias*precioPorDia,fecha);
	}
	
	public double PrecioTotal(int dias) {
		return this.precioPorDia * dias;
	}
	
	public PoliticaDevolucion getPolitica() {
		return this.politica;
	}
	
	public void setPolitica(PoliticaDevolucion pol) {
		this.politica = pol;
	}
}
