package Clases;

public class DecoratorModificacion extends FileDecorator{
	
	public DecoratorModificacion(Component comp) {
		super(comp);
	}
	
	public String prettyPrint() {
		return super.getModificacion() + " - " + super.prettyPrint();
	}
}
