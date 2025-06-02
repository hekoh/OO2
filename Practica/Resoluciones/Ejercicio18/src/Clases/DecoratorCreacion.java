package Clases;

public class DecoratorCreacion extends FileDecorator{
	
	public DecoratorCreacion(Component comp) {
		super(comp);
	}
	
	public String prettyPrint() {
		return super.getCreacion() + " - " + super.prettyPrint();
	}
	
}
