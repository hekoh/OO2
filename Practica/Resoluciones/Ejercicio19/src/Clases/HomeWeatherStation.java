package Clases;

import java.util.List;

public class HomeWeatherStation implements WeatherData{
	private double temperatura;
	private double presion;
	private double radiacion;
	private List<Double> temperaturas;
	
	
	public HomeWeatherStation(double temp, double presion, double radiacion, List<Double> temps) {
		this.temperatura = temp;
		this.presion = presion;
		this.radiacion = radiacion;
		this.temperaturas = temps;
	}


	public double getTemperatura() {
		return temperatura;
	}


	public double getPresion() {
		return presion;
	}


	public double getRadiacionSolar() {
		return radiacion;
	}


	public List<Double> getTemperaturas() {
		return temperaturas;
	}
	
	
	public String displayData() {
		return "Temperatura F: " + this.getTemperatura() +
				" Presión atmosf: " + this.getPresion() +
				" Radiación solar: " + this.getRadiacionSolar();
	}
	
	
}
