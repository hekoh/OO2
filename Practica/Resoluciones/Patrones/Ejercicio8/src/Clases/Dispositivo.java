package Clases;

public class Dispositivo {
	private Ringer ringer;
	private Calculator crcCalculator;
	private Connection connection;
	private Display display;
	
	
	public Dispositivo(Calculator calc, Connection conect) {
		this.ringer = new Ringer();
		this.crcCalculator = calc;
		this.display = new Display();
		this.connection = conect;
	}
	
	
	public String send(String data) {
		return connection.sendData(data, crcCalculator.crcFor(data));	
	}
	
	public void conectarCon (Connection conect) {
		this.connection = conect;
		this.ringer.ring();
		System.out.println(display.showBanner(conect.pict()));
	}
	
	public void configurarCRC(Calculator calc) {
		this.crcCalculator = calc;
	}
	
	public Calculator getCalculator() {
		return this.crcCalculator;
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
}
