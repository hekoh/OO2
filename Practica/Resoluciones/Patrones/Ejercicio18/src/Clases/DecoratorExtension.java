package Clases;

public class DecoratorExtension extends FileDecorator{

	
	public DecoratorExtension(Component comp) {
		super(comp);
	}
	
	public String prettyPrint() {
		return super.getExtension() + " - " + super.prettyPrint();
	}
	
}
