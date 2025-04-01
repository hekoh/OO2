package Clases;

public class Tijera extends Jugada{
	
	public String JugarContra(Jugada jugada) {
		return jugada.JugarContraTijera();
	}
	
	@Override
	public String JugarContraPiedra() {
		return("perdio");
	}
	@Override 
	public String JugarContraPapel() {
		return ("gano");
	}
	@Override
	public String JugarContraTijera() {
		return("empate");
	}
}
