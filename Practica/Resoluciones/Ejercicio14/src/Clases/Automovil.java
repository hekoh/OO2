package Clases;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Automovil extends Prenda{
	private LocalDate modelo;
	private double kilometraje;
	private double costo0km;
	
	
	
	public Automovil(LocalDate modelo, double km, double costo) {
		this.modelo = modelo;
		this.kilometraje = km;
		this.costo0km = costo;
	}
	
	public double Liquidez() {
		return 0.7;
	}
	
	public double Valor() {
		if(this.getAntiguedad() <= 10)
			return this.costo0km * (1 - (0.1 * this.getAntiguedad()));
		return 0;
	}
	
	public int getAntiguedad() {
		return (int) ChronoUnit.YEARS.between(modelo, LocalDate.now()); 
	}
	
	public double valorPrendario() {
		return Valor() * Liquidez();
	}
	
}
