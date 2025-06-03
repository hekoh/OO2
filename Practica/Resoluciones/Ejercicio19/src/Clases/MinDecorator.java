package Clases;

public class MinDecorator extends WeatherDecorator{
	
	
	
	public MinDecorator(WeatherData data) {
		super(data);
	}
	
	
	private double minimo() {
		return super.getTemperaturas().stream().
				min((T1,T2) -> T1.compareTo(T2)).orElse(0.0);
	}
	
	public String displayData() {
		return super.displayData() + " Minimo: " + this.minimo();
	}
	
}
