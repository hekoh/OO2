package Clases;

public abstract class Operando implements EstadoCalc{

	
	public void mas(Calculadora calc) {
		calc.setEstado(new Error());
	}
	public void menos(Calculadora calc) {
		calc.setEstado(new Error());
	}
	public void dividido(Calculadora calc) {
		calc.setEstado(new Error());
	}
	public void por(Calculadora calc) {
		calc.setEstado(new Error());
	}
	
	public abstract void setValor(double valor, Calculadora calc);
	
	public String getResultado(Calculadora calc) {
		return "" + calc.getResultado();
	}
	
}
