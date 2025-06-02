package Clases;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler extends Prenda{
	private LocalDate inicio;
	private LocalDate fin;
	private double costoMes;
	
	
	public Alquiler(LocalDate inicio, LocalDate fin, double costo) {
		this.inicio = inicio;
		this.fin = fin;
		this.costoMes = costo;
	}
	
	
	public double Valor() {
		return costoMes * ChronoUnit.MONTHS.between(LocalDate.now(), fin);
	}
	
	public double Liquidez() {
		return 0.9;
	}
	
	public double valorPrendario() {
		return Valor() * Liquidez();
	}
	
}
