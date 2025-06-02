package Clases;

public class AdaptadorFeistel implements Cifrado{
	private FeistelCipher algoritmo;
	
	public AdaptadorFeistel(String clave) {
		this.algoritmo = new FeistelCipher(clave);
	}
	
	public String encriptar(String mensaje) {
		return this.algoritmo.encode(mensaje);
	}
	
	public String desencriptar(String mensaje) {
		return this.algoritmo.encode(mensaje);
	}
}
