package Clases;

import java.time.LocalDate;

public abstract class FileDecorator implements Component {
	private Component comp;
	
	
	public FileDecorator(Component comp) {
		this.comp = comp;
	}
	
	public String prettyPrint() {
		return this.comp.prettyPrint();
	}
	public String getNombre() {
		return this.comp.getNombre();
	}
	public String getExtension() {
		return this.comp.getExtension();
	}
	public double getTamaño() {
		return this.comp.getTamaño();
	}
	public LocalDate getCreacion() {
		return this.comp.getCreacion();
	}
	public LocalDate getModificacion() {
		return this.comp.getModificacion();
	}
	
	public String getPermisos() {
		return this.comp.getPermisos();
	}
}
