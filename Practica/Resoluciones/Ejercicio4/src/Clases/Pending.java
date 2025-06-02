package Clases;

import java.time.Duration;

public class Pending extends State {
	
	public Pending(ToDoItem item, String nombre) {
		super(item, nombre);
	}
	
	public void start() {
		super.start();		//evita feature envy?
	}
	public void togglePause() {
		throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
	}
	public void finish() {
	}
	public Duration workedTime() {
		throw new RuntimeException("El item esta en estado pendiente y por lo tanto no se trabajo sobre el");
	}
	
	public void addComment(String comment) {
		super.addComment(comment);
	}
}
