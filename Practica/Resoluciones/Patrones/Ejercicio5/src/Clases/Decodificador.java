package Clases;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Decodificador {
	private List<Pelicula> peliculas;
	private List<Pelicula> reproducidas;
	private Sugerencia algoritmo;
	
	
	public Decodificador() {
		this.peliculas = new ArrayList<Pelicula>();
		this.reproducidas = new ArrayList<Pelicula>();
	}
	
	public void setSugerencia(Sugerencia algoritmo) {
		this.algoritmo = algoritmo;
	}
	
	
	public void verPelicula(Pelicula pelicula) {
		this.reproducidas.add(pelicula);
	}
	
	public List<Pelicula> sugerir() {
		return this.algoritmo.sugerencia(peliculas, reproducidas).stream().limit(3).collect(Collectors.toList());
	}
	
	public void añadirPelicula(Pelicula pelicula) {
		this.peliculas.add(pelicula);
	}
}
