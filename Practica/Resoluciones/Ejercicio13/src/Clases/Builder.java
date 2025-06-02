package Clases;

public abstract class Builder {
	private Sandwich sandwich;
	
	
	public abstract void crearSandwich();		//consultar este metodo
	
	public void setPan(Ingrediente pan) {
		this.sandwich.setPan(pan);
	}
	
	public void setAdereso(Ingrediente adereso) {
		this.sandwich.setAdereso(adereso);
	}
	
	public void setPrincipal(Ingrediente principal) {
		this.sandwich.setPrincipal(principal);
	}
	public void setAdicional(Ingrediente adicional) {
		this.sandwich.setAdicional(adicional);
	}
	
	public Sandwich obtenerResultado() {
		return this.sandwich;
	}
}
