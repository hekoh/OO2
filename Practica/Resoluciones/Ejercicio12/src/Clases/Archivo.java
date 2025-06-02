package Clases;

import java.time.LocalDate;

public class Archivo extends Elemento{
	private int tamaño;
	
	
	public Archivo(String nombre, LocalDate fecha, int tamaño) {
		super(nombre,fecha);
		this.tamaño = tamaño;
	}
	
	
	public int tamaño() {
		return this.tamaño;
	}
	
	public Archivo archivoMasGrande() {
		return this;
	}
	
	public Archivo archivoMasNuevo() {
		return this;
	}
	
	public LocalDate getFecha() {
		return super.getFecha();
	}
	
	public String listadoDeContenido(String prefijo) {
		return prefijo + "/" + super.getNombre();
	}
}
