package Clases;

public class BuilderIntermedio extends BuilderPC{
	private Presupuesto presupuesto;
	
	
	public BuilderIntermedio(Catalogo cat) {
		super(cat);
		this.presupuesto = new Presupuesto();
	}
	
	public void setProcesador() {
		this.presupuesto.setProcesador(super.getComponente("Procesador Intermedio"));
	}
	
	public void setRam() {
		this.presupuesto.setRam(super.getComponente("16 GB"));
	}
	
	public void setDisco() {
		this.presupuesto.setDisco(super.getComponente("SSD 500 GB"));
	}
	
	public void setGrafica() {
		this.presupuesto.setGrafica(super.getComponente("GTX 1650"));
	}
	
	public void setGabinete() {
		this.presupuesto.setGabinete(super.getComponente("Gabinete Intermedio"));
		this.presupuesto.setGabinete(super.getComponente("Fuente 800 w"));
	}
	
	public Presupuesto getResultado() {
		return this.presupuesto;
	}
	
}
