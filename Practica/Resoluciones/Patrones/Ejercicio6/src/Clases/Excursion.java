package Clases;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Excursion {
	private String nombre;
	private LocalDate inicio;
	private LocalDate fin;
	private String encuentro;
	private double costo;
	private int minimo;
	private int maximo;
	private StateEx estado;
	private List<Usuario> inscriptos;
	private List<Usuario> espera;
	

	public Excursion(String nombre, LocalDate inicio, LocalDate fin, String encuentro, double costo, int minimo, int maximo) {
		this.nombre = nombre;
		this.inicio = inicio;
		this.fin = fin;
		this.encuentro = encuentro;
		this.costo = costo;
		this.minimo = minimo;
		this.maximo = maximo;
		this.estado = new Provisoria(this.minimo);
		this.inscriptos = new ArrayList<Usuario>();
		this.espera = new ArrayList<Usuario>();
	}

	public void inscribir(Usuario usuario) {
		if(inscriptos.size() < this.maximo) {
			this.inscriptos.add(usuario);
		}
		else {
			this.espera.add(usuario);
		}
		this.estado.inscribir(this);
	}
	
	public void setEstado(StateEx estado) {
		this.estado = estado;
	}
	
	public List<Usuario> getInscriptos(){
		return this.inscriptos;
	}
	
	public int getMinimo() {
		return this.minimo;
	}
	public int getMaximo() {
		return this.maximo;
	}
	
	public StateEx getEstado() {
		return this.estado;
	}
	
	public List<Usuario> getEspera(){
		return this.espera;
	}
	
	private int Duracion() {
		return (int) ChronoUnit.DAYS.between(inicio, fin);
	}
	
	public String obtenerInformacion() {
		String aux = "nombre: " + this.nombre + 
				"\n costo: " + this.costo + 
				"\n inicio: " + this.inicio.toString() +
				"\n fin: " + this.fin.toString() +
				"\n punto de encuentro: " + this.encuentro; 
		return aux + estado.obtenerInformacion();
	}
}
