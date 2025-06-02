package Clases;

public class WifiConn implements Connection {
	private String pict;
	
	
	public WifiConn(String pict) {
		this.pict = pict;
	}
	
	
	public String sendData(String data, int crc) {
		return ("Se recibio el string "+ data + " y se devolvio " + crc + "\n" + "conexion wifi ");
	}
	
	public String pict() {
		return this.pict;
	}
	
}
