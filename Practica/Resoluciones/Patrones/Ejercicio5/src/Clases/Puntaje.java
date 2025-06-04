package Clases;

import java.util.List;
import java.util.stream.Collectors;


public class Puntaje implements Sugerencia{
	
	
	public List<Pelicula> sugerencia(List<Pelicula> peliculas, List<Pelicula> reproducidas){
		List<Pelicula> aux;
		aux = peliculas.stream().filter(p -> !reproducidas.contains(p)).
								collect(Collectors.toList()); 		//Filtra las reproducidas
		aux = aux.stream().sorted((p1,p2) -> Pelicula.compare(p2, p1)).
								collect(Collectors.toList());		//ordena por puntaje y por fecha
		return aux;
	}
}
