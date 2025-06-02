package Clases;

import java.util.List;
import java.util.ArrayList;

public class Sandwich {
	private List<Ingrediente> ingredientes;	
	
	public Sandwich() {
		this.ingredientes = new ArrayList<Ingrediente>();
	}
	
	public double getPrecio() {
		return this.ingredientes.stream().mapToDouble(i -> i.getPrecio()).sum();
	}
	
	public void setPan(Ingrediente pan) {
		this.ingredientes.add(pan);
	}
	
	public void setAdereso(Ingrediente adereso) {
		this.ingredientes.add(adereso);
	}
	
	public void setPrincipal(Ingrediente principal) {
		this.ingredientes.add(principal);
	}
	public void setAdicional(Ingrediente adicional) {
		this.ingredientes.add(adicional);
	}
	
}
