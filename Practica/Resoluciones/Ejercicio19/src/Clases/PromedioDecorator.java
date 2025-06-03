package Clases;

public class PromedioDecorator extends WeatherDecorator{
	
	
	public PromedioDecorator(WeatherData data) {
		super(data);
	}
	
	
	private double promedio() {
		return Math.round( super.getTemperaturas().stream().
				mapToDouble(T -> T).average().orElse(0.0));
	}
	
	public String displayData() {
		return super.displayData() + " Promedio: " + this.promedio();
	}
}
