package Clases;

public class Calculadora {
	private EstadoCalc estado;
	private double valorAcumulado;
	
	
	public Calculadora() {
		this.valorAcumulado = 0;
		this.estado = new Inicial();
	}
	
	public void mas() {
		this.estado.mas(this);
	}
	
	public void menos() {
		this.estado.menos(this);
	}
	
	public void por() {
		this.estado.por(this);
	}
	
	public void dividido() {
		this.estado.dividido(this);
	}
	
	public void setValor(double valor) {
		this.estado.setValor(valor,this);
	}
	
	public String getResultado() {
		return this.estado.getResultado(this);
	}
	
	public void setValorAc(double num) {
		this.valorAcumulado = num;
	}
	
	public double getValorAc() {
		return this.valorAcumulado;
	}
	
	public void setEstado(EstadoCalc estado) {
		this.estado = estado;
	}
	
	public void borrar() {
		this.valorAcumulado = 0;
		this.setEstado(new Inicial());
	}
	
	public EstadoCalc getEstado() {
		return this.estado;
	}
}
