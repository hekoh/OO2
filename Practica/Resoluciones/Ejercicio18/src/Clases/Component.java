package Clases;

import java.time.LocalDate;

public interface Component {
	
	public String prettyPrint();
	public String getNombre();
	public String getExtension();
	public double getTamaño();
	public LocalDate getCreacion();
	public LocalDate getModificacion();
	public String getPermisos();
}
