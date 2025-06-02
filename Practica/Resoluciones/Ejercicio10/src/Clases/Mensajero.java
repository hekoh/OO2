package Clases;

public class Mensajero {
	private Cifrado algoritmo;
	
	
	public Mensajero(Cifrado algoritmo) {
		this.algoritmo = algoritmo;
	}
	
	public void enviar(String mensaje) {
		algoritmo.encriptar(mensaje);
	}
	
	public void recibir(String mensaje) {
		algoritmo.desencriptar(mensaje);
	}
}
