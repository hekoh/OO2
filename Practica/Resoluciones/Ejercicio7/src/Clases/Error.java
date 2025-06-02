package Clases;

public class Error implements EstadoCalc{
		
	 public void mas(Calculadora c) {}

	 public void menos(Calculadora c) {}

	 public void por(Calculadora c) {}

	 public void dividido(Calculadora c) {}

	 public void setValor(double unValor, Calculadora c) {}
	 
	 @Override
	 public String getResultado(Calculadora c) {
		 return "error";
	 }
}
