package Clases;

public class Papel extends Jugada {

	
	public String JugarContra(Jugada jugada) {
		return jugada.JugarContraPapel();
	}
	
	@Override
	public String JugarContraPiedra() {
		return("gano");
	}
	@Override 
	public String JugarContraPapel() {
		return ("empate");
	}
	@Override
	public String JugarContraTijera() {
		return("perdio");
	}
}
