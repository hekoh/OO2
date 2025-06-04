package Clases;

public class Acero implements Armadura{
	
	
	public int RecibirDaño(Arma arma) {
		return arma.DañoContraAcero();
	}
	
}
