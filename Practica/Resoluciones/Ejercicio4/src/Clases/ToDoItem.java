package Clases;

import java.time.Duration;
import java.time.Instant;

public class ToDoItem {
	private State estado;
	private Instant inicio;

	
	public ToDoItem(String nombre) {
		this.estado = new Pending(this,nombre);	
	}
	
	public void setState(State estado) {
		this.estado = estado;
	}
	
	public State getState() {
		return this.estado;
	}
	
	public Instant getInicio() {
		return this.inicio;
	}
	
	
	public void start() {
		this.estado.start();
		this.inicio = Instant.now();
	}
	public void togglePause() {
		try {
			this.estado.togglePause();
		}
		catch(RuntimeException error) {
			System.out.println(error);
		}
	}
	public void finish() {
		this.estado.finish();
	}
	public Duration workedTime() {
		try {
			return this.estado.workedTime();
		} catch(RuntimeException error){
			System.out.println(error);
			return Duration.ofSeconds(0);
		}
	}
	
	public void addComment(String comment) {
		this.estado.addComment(comment);
	}
}
