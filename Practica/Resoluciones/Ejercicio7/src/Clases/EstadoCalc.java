package Clases;

public interface EstadoCalc {
	
	
	
	public void setValor(double valor, Calculadora calc);
	public void mas(Calculadora calc);
	public void menos(Calculadora calc);
	public void dividido(Calculadora calc);
	public void por(Calculadora calc);
	public String getResultado(Calculadora calc);
}
