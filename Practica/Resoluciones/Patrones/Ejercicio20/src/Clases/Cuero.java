package Clases;

public class Cuero implements Armadura{
	
	
	public int RecibirDaño(Arma arma) {
		return arma.DañoContraCuero();
	}
	
}
