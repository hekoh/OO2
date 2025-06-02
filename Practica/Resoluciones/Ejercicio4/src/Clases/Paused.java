package Clases;

import java.time.Duration;

public class Paused extends State{
	
	public Paused(ToDoItem item, String nombre) {
		super(item,nombre);
	}
	
	public void start() {
	}
	public void togglePause() {
		ToDoItem item = super.getItem();
		item.setState(new InProgress(item,super.getName()));
	}
	public void finish() {
		super.finish();
	}
	public Duration workedTime() {
		return super.workedTime();
	}
	
	public void addComment(String comment) {
		super.addComment(comment);
	}
}
