package Clases;


public class Provisoria extends StateEx{
	private int faltante;
	
	
	public Provisoria (int faltante) {
		this.faltante = faltante;
	}
	
	public void inscribir(Excursion excursion) {
		if(faltante >=2)
			this.faltante -= 1;
		else 
			excursion.setEstado(new Definitiva(excursion.getMaximo() - excursion.getMinimo(),
												excursion.getInscriptos()));
	}
	
	public String obtenerInformacion() {
		return "\n Inscripciones faltantes para iniciar la excursion: " + this.faltante;
	}
	
}
