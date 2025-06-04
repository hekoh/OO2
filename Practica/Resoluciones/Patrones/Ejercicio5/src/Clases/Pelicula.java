package Clases;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Pelicula {
	private String titulo;
	private LocalDate estreno;
	private double puntaje;
	private List<Pelicula> similares;
	
	
	public Pelicula(String titulo, LocalDate estreno, double puntaje) {
		this.titulo = titulo;
		this.estreno = estreno;
		this.puntaje = puntaje;
		this.similares = new ArrayList<Pelicula>();
	}
	
	public void añadirSimilar(Pelicula pelicula) {
		if(!this.similares.contains(pelicula)) {
			this.similares.add(pelicula);
			pelicula.añadirSimilar(this);
		}
	}
	
	public List<Pelicula> getSimilares(){
		return this.similares;
	}
	
	public LocalDate getEstreno() {
		return this.estreno;
	}
	
	public String toString() {
		return this.titulo;
	}
	
	public double getPuntaje() {
		return this.puntaje;
	}
	
	
	public static int compare(Object o1, Object o2) {
		
		 Double x1 = ((Pelicula) o1).getPuntaje();
         Double x2 = ((Pelicula) o2).getPuntaje();
         int sComp = x1.compareTo(x2);
         System.out.println(sComp);

         if (sComp != 0) {
            return sComp;
         } 

         LocalDate y1 = ((Pelicula) o1).getEstreno();
         LocalDate y2 = ((Pelicula) o2).getEstreno();
         return y1.compareTo(y2);
	}
}
