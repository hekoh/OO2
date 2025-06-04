package Clases;

public class BuilderSinTACC extends Builder{
	
	
	public void setPan() {
		super.setPan(new Ingrediente("Pan de chipá",150.0));
	}
	
	public void setAdereso() {
		super.setAdereso(new Ingrediente("Salsa tartara",18.0));
	}
	
	public void setPrincipal() {
		super.setPrincipal(new Ingrediente("Carne de pollo",250.0));
	}
	
	public void setAdicional() {
		super.setPrincipal(new Ingrediente("verduras grilladas",200.0));
	}
	
	public void crearSandwich() {
		setPan();
		setAdereso();
		setPrincipal();
		setAdicional();
	}
	
}
