package Clases;

import java.util.List;
import java.util.ArrayList;


public class Mixta implements Composicion{
	private List<Composicion> celdas;
	
	
	public Mixta() {
		this.celdas = new ArrayList<Composicion>();
	}
	
	public void añadirCelda(Composicion celda) {
		if(celdas.size()<4)
			this.celdas.add(celda);
	}
	
	public double proporcionAgua() {
		if(celdas.size() == 4)
			return celdas.stream().mapToDouble(c -> c.proporcionAgua()).average().orElse(0);
		return 0.0;
	}
	
	protected List<Composicion> getLista(){
		return this.celdas;
	}
	
	@Override
	public boolean equals(Object mixta) {
		return ((mixta.getClass() == Mixta.class)? this.celdas.equals(((Mixta)mixta).getLista()): false);
	}
}
