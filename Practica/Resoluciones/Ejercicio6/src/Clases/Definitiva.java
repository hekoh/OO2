package Clases;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
	
public class Definitiva extends StateEx{
	private int faltantes;
	private List<String> mails;
	
	
	
	public Definitiva(int faltantes, List<Usuario> usuarios) {
		this.faltantes = faltantes;
		this.mails = usuarios.stream().map(U -> U.getMail()).collect(Collectors.toList());
	}
	
	public void inscribir(Excursion excursion) {
		if(this.faltantes >=2) {
			faltantes -= 1;
			List<Usuario> aux = excursion.getInscriptos();
			mails.add(aux.get(aux.size()-1).getMail());
		}
		else
			excursion.setEstado(new Llena());
	}
	
	public String obtenerInformacion() {
		return "\n Inscripciones para llenar el cupo: " + this.faltantes + "\n" + 
														mails.stream().map(u -> u.toString()).collect(Collectors.joining("\n"));
	}
	
}
