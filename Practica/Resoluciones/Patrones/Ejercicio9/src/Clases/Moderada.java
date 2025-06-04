package Clases;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Moderada implements PoliticaDevolucion{

	public double devolucion(double precio, LocalDate fecha) {
		if(ChronoUnit.DAYS.between(LocalDate.now(), fecha) >= 6){
			return precio;
		}
		else if(ChronoUnit.DAYS.between(LocalDate.now(), fecha) >= 2){
			return precio*0.5;
		}
		else
			return 0.0;
	}
	
}
