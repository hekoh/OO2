package Clases;

public class Adapter4G implements Connection{
	private Conexion4g adaptado;
	
	
	public Adapter4G (Conexion4g adaptado) {
		this.adaptado = adaptado;
	}
	
	public String sendData(String data, int crc) {
		return this.adaptado.transmit(data, crc);
	}
	
	public String pict() {
		return this.adaptado.getSymb();
	}
	
}
