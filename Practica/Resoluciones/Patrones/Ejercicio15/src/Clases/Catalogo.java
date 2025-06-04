package Clases;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Catalogo {
	private List<Componente> componentes;
	
	
	public Catalogo() {
		this.componentes = new ArrayList<Componente>();
	}
	
	public void agregarComponente(Componente comp) {
		this.componentes.add(comp);
	}
	
	public Componente getComponente(String descripcion) {
		return this.componentes.stream().filter(c -> c.getDescripcion().contains(descripcion) == true).
				collect(Collectors.toList()).get(0);
	}
	
}
