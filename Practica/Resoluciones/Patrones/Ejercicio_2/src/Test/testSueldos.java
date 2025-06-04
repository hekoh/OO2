	package Test;

import Clases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;


public class testSueldos {
	public Temporario temporario;
	public Pasante pasante;
	public Planta planta;
	
	@BeforeEach
	public void setup() {
		this.temporario = new Temporario("luca",90,1,true);
		this.pasante = new Pasante("Juan",5);
		this.planta = new Planta("Jose",LocalDate.of(2024, 5, 10),2,false);
	}
	
	
	@Test
	public void testSueldo() {
		assertEquals(temporario.sueldo(),47540.0);
		assertEquals(pasante.sueldo(),26900.0);
		assertEquals(planta.sueldo(),47300.0);
	}
	
}
