package Clases;

public class BuilderClasico extends Builder{

	
	public void setPan() {
		super.setPan(new Ingrediente("Pan brioche",100.0));
	}
	
	public void setAdereso() {
		super.setAdereso(new Ingrediente("mayonesa",20.0));
	}
	
	public void setPrincipal() {
		super.setPrincipal(new Ingrediente("Carne de ternera",300.0));
	}
	
	public void setAdicional() {
		super.setPrincipal(new Ingrediente("tomate",80.0));
	}
	
	public void crearSandwich() {
		setPan();
		setAdereso();
		setPrincipal();
		setAdicional();
	}
	
}
