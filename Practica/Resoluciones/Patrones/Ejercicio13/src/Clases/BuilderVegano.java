package Clases;

public class BuilderVegano extends Builder{
	
	
	public void setPan() {
		super.setPan(new Ingrediente("Pan integral",100.0));
	}
	
	public void setAdereso() {
		super.setAdereso(new Ingrediente("Salsa criolla",20.0));
	}
	
	public void setPrincipal() {
		super.setPrincipal(new Ingrediente("Milanesa de girgolas",500.0));
	}
	
	public void setAdicional() {}
	
	public void crearSandwich() {
		setPan();
		setAdereso();
		setPrincipal();
		setAdicional();
	}
}
