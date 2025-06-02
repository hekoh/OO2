package Clases;

import java.time.LocalDate;

public abstract class Elemento {
	private String nombre;
	private LocalDate fechaCreacion;
	
	
	public Elemento(String nombre, LocalDate fecha) {
		this.nombre = nombre;
		this.fechaCreacion = fecha;
	}
	
	
	public abstract int tamaño();
	
	public abstract Archivo archivoMasGrande();
	
	public abstract Archivo archivoMasNuevo();
	
	public abstract String listadoDeContenido(String prefijo);

	public LocalDate getFecha() {
		return this.fechaCreacion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	
	
	
	
}



