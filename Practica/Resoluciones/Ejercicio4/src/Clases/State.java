package Clases;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

public abstract class State {
	private ToDoItem item;
	private String nombre;
	private List<String> comentarios;
	
	public State(ToDoItem item, String nombre) {
		this.item = item;
		this.nombre = nombre;
		this.comentarios = new ArrayList<String>();
	}
	
	public ToDoItem getItem() {
		return this.item;
	}
	
	public String getName() {
		return this.nombre;
	}
	
	protected void start() {
		item.setState(new InProgress(item,nombre));
	}
	
	public abstract void togglePause();
	
	protected void finish() {
		this.item.setState(new Finished(item,nombre));
	}
	
	protected Duration workedTime() {
		return Duration.between(item.getInicio(), Instant.now());
	}
	
	public void addComment(String comment) {
		this.comentarios.add(comment);
	}
	
	public List<String> getComentarios(){
		return this.comentarios;
	}
	
}
