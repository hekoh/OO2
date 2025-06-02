package Clases;

public class DecoratorTamaño extends FileDecorator{
	
	public DecoratorTamaño(Component comp) {
		super(comp);
	}
	
	public String prettyPrint() {
		return super.getTamaño() + " - " + super.prettyPrint();
	}
}
