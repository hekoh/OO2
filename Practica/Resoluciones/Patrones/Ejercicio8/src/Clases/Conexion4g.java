package Clases;

public class Conexion4g{
	private String Symb; 
	
	
	public Conexion4g(String symb) {
		this.Symb = symb;
	}
	
	public String transmit(String data, int crc) {
		return ("Se recibio el string "+ data + " y se devolvio " + crc + "\n" + 
				"conexion 4G");
	}
	
	public String getSymb() {
		return this.Symb;
	}
}
