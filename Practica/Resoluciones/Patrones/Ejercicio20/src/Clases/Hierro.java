package Clases;

public class Hierro implements Armadura{

	
	public int RecibirDaño(Arma arma) {
		return arma.DañoContraHierro();
	}
	
}
