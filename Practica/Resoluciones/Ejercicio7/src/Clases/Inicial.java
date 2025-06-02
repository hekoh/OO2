package Clases;

public class Inicial extends Operando{
	
    public void mas(Calculadora calc) {
        calc.setEstado(new Sumando());
    }

    public void menos(Calculadora calc) {
        calc.setEstado(new Restando());
    }

    public void por(Calculadora calc) {
        calc.setEstado(new Multiplicando());
    }

    public void dividido(Calculadora calc) {
        calc.setEstado(new Dividiendo());
    }

	public void setValor(double unValor, Calculadora calc) {
		calc.setValorAc(unValor);
	}

	public String getResultado(Calculadora calc) {
		return Double.toString(calc.getValorAc());
	}
}
