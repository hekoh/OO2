package Clases;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private List<AutoEnAlquiler> autos;
	
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.autos = new ArrayList<AutoEnAlquiler>();
	}
	
}
