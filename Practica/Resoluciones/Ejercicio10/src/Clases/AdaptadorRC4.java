package Clases;

public class AdaptadorRC4 implements Cifrado{
	private RC4 algoritmo;
	private String clave;
	
	
	public AdaptadorRC4(String clave) {
		this.clave = clave;
		this.algoritmo = new RC4();
	}
	
	public String encriptar(String mensaje) {
		return this.algoritmo.encriptar(mensaje, clave);
	}
	
	public String desencriptar(String mensaje) {
		return this.algoritmo.desencriptar(mensaje, clave);
	}
}
