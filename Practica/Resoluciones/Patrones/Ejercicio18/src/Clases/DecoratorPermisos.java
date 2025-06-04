package Clases;

public class DecoratorPermisos extends FileDecorator{
	
	public DecoratorPermisos(Component comp) {
		super(comp);
	}
	
	public String prettyPrint() {
		return super.getPermisos() + " - " + super.prettyPrint();
	}
}
