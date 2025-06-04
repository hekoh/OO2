package Clases;

public class BuilderVegetariano extends Builder{

	public void setPan() {
		super.setPan(new Ingrediente("Pan con semillas",120.0));
	}
	
	public void setAdereso() {}
	
	public void setPrincipal() {
		super.setPrincipal(new Ingrediente("Provoleta grillada",200.0));
	}
	
	public void setAdicional() {
		super.setPrincipal(new Ingrediente("Berenjenas al escabeche",100.0));
	}
	
	public void crearSandwich() {
		setPan();
		setAdereso();
		setPrincipal();
		setAdicional();
	}
	
	
}
