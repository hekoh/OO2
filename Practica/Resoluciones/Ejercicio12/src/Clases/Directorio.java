package Clases;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Directorio extends Elemento{
	private List<Elemento> contenido;
	
	
	public Directorio(String nombre, LocalDate fecha) {
		super(nombre,fecha);
		this.contenido = new ArrayList<Elemento>();
	}
	
	
	public int tamaño() {
		return 32 + (contenido.stream().mapToInt(c -> c.tamaño()).sum());
	}
	
	public void añadirElemento(Elemento elem) {
		this.contenido.add(elem);
	}
	
	
	public Archivo archivoMasGrande() {
		return contenido.stream().map(e1 -> e1.archivoMasGrande())
				.max((a1,a2) -> Integer.compare(a1.tamaño(), a2.tamaño()))
					.orElse(new Archivo("aux",LocalDate.now(),0));	//si el directorio no tiene archivos devuelve un
	}																//auxiliar de peso 0
	
	public Archivo archivoMasNuevo() {
		return contenido.stream().map(e1 -> e1.archivoMasNuevo())
			.max((f1,f2) -> f1.getFecha().compareTo(f2.getFecha()))		
				.orElse(new Archivo("aux",LocalDate.now().minusDays(99999),0));	//Si el directorio no tiene archivos
																				//devuelve un auxiliar con fecha antigua
	}
	
	public Elemento Buscar(String nombre) {
		return contenido.stream().filter(e -> e.getNombre() == nombre).findFirst().orElse(null);
	}
	
	public List<Elemento> BuscarTodos(String nombre) {
		return contenido.stream().filter(e -> e.getNombre() == nombre).collect(Collectors.toList());
	}
	
	public String listadoDeContenido(String prefijo) {
		String pre = prefijo + "/" + this.getNombre();
		String aux = pre;
		for(int i = 0; i < contenido.size(); i++) {
			aux = aux + "\n" + contenido.get(i).listadoDeContenido(pre);
		}
		return aux;
	}
	
	

}
