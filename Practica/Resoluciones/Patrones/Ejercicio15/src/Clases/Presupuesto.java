package Clases;

import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private List<Componente> componentes;
	
	
	public Presupuesto() {
		this.componentes = new ArrayList<Componente>();
	}
	
	public void setProcesador(Componente procesador) {
		this.componentes.add(procesador);
	}
	
	public void setRam(Componente ram) {
		this.componentes.add(ram);
	}
	
	public void setDisco(Componente disco) {
		this.componentes.add(disco);
	}
	
	public void setGrafica(Componente grafica) {
		this.componentes.add(grafica);
	}
	
	public void setGabinete(Componente gabinete) {
		this.componentes.add(gabinete);
	}

	public double calcularConsumo() {
		return componentes.stream().mapToDouble(c -> c.getConsumo()).sum();
	}
	
	public double calcularPrecio() {
		return 1.21 * (componentes.stream().mapToDouble(c -> c.getPrecio()).sum());
	}
}
