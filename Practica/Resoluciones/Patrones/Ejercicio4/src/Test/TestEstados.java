package Test;

import Clases.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class TestEstados {
	private ToDoItem item;
	
	@Test
	public void testPending() {
		item = new ToDoItem("prueba");
		assertEquals(item.getState().getClass(),Pending.class);
		assertEquals(item.workedTime(),Duration.ZERO);
		item.finish();
		assertEquals(item.getState().getClass(),Pending.class); //la clase no deberia cambiar
		item.togglePause();
		assertEquals(item.getState().getClass(),Pending.class); //la clase no cambia, el error se atrapa antes 
																	//para no detener la ejecucion
	}
	@Test
	public void testProgressPaused() {
		item = new ToDoItem("prueba");
		item.start();
		assertEquals(item.getState().getClass(),InProgress.class);
		assertEquals(item.workedTime(),Duration.ofSeconds(0));
		item.togglePause();
		assertEquals(item.getState().getClass(),Paused.class);
		item.togglePause();
		assertEquals(item.getState().getClass(),InProgress.class);
		item.finish();
		assertEquals(item.getState().getClass(),Finished.class);
	}
	
	@Test
	public void testFinish() throws InterruptedException {
		item = new ToDoItem("prueba");
		item.start();
		item.finish();
		assertEquals(item.getState().getClass(),Finished.class);
		item.togglePause();
		assertEquals(item.getState().getClass(),Finished.class);
		TimeUnit.SECONDS.sleep(3);
		assertNotEquals(item.workedTime(), Duration.ofSeconds(3));
	}
}
