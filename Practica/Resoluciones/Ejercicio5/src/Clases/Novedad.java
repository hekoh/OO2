package Clases;

import java.util.List;
import java.util.stream.Collectors;


public class Novedad implements Sugerencia{
	
	
	public List<Pelicula> sugerencia(List<Pelicula> peliculas, List<Pelicula> reproducidas){
		List<Pelicula> aux;
		aux = peliculas.stream().filter(p -> !reproducidas.contains(p)).
										collect(Collectors.toList()); 	//Filtra las reproducidas
		aux = aux.stream().sorted((p1,p2) -> p2.getEstreno().compareTo(p1.getEstreno())).
										collect(Collectors.toList()); 	//Las ordena por mas reciente
		return aux;
	}
	
}
