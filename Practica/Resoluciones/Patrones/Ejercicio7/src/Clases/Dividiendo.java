package Clases;

public class Dividiendo extends Operando{

	public void setValor(double valor, Calculadora calc) {
		calc.setValorAc(calc.getValorAc() / valor);
		calc.setEstado(new Inicial());
	}
	
}
