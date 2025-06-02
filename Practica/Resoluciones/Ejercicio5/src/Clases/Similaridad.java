package Clases;

import java.util.List;
import java.util.stream.Collectors;


public class Similaridad implements Sugerencia{
	
	
	public List<Pelicula> sugerencia(List<Pelicula> peliculas, List<Pelicula> reproducidas){
		List<Pelicula> aux;
		aux = reproducidas.stream().filter(p -> p.getSimilares().size() > 0).	//filtra las peliculas sin sugerencias
									collect(Collectors.toList()); 	
		
		aux = aux.stream().map(p -> p.getSimilares()).							//arma una lista con los sugeridos
									flatMap(List::stream).	
									collect(Collectors.toList()); 		
		
		aux = aux.stream().sorted((p1, p2) -> p2.getEstreno().					//filtra las sugerencias por fecha
									compareTo(p1.getEstreno()))	
									.collect(Collectors.toList());		
		
		aux = aux.stream().distinct().											//filtra las ya reproducidas y repetidas
								filter(p -> !reproducidas.contains(p)).
								collect(Collectors.toList()); 
		return aux;
	}
}
