package Clases;

public class Inmueble extends Prenda{
	private String direccion;
	private double superficie;
	private double costoM;
	
	
	public Inmueble(String dir, double superficie, double costo) {
		this.direccion = dir;
		this.superficie = superficie;
		this.costoM = costo;
	}
	
	public double Liquidez() {
		return 0.2;
	}
	
	public double Valor() {
		return superficie * costoM;
	}
	
	public double valorPrendario() {
		return Valor() * Liquidez();
	}
	
}
