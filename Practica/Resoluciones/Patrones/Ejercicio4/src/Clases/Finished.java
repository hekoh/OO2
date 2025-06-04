package Clases;

import java.time.Duration;
import java.time.Instant;

public class Finished extends State{
	private Instant fin;
	
	public Finished(ToDoItem item, String nombre) {
		super(item,nombre);
		this.fin = Instant.now();
	}
	
	public void start() {
	}
	public void togglePause() {
		throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
	}
	public void finish() {
	}
	public Duration workedTime() {
		return Duration.between(super.getItem().getInicio(), fin);
	}
	
	public void addComment(String comment) {
	}
}
