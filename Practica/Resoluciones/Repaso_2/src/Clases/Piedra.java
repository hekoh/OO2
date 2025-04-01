package Clases;

public class Piedra extends Jugada {
	
	
	public String JugarContra(Jugada jugada) {
		return jugada.JugarContraPiedra();
	}
	
	@Override
	public String JugarContraPiedra() {
		return("empate");
	}
	@Override 
	public String JugarContraPapel() {
		return ("pierde");
	}
	@Override
	public String JugarContraTijera() {
		return("gana");
	}



	
}
