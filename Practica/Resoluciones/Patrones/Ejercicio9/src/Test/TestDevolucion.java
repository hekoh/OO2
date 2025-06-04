package Test;

import Clases.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;

public class TestDevolucion {
	public Usuario user;
	public AutoEnAlquiler auto;
	public Reserva reserva;
	
	
	@BeforeEach
	public void setup() {
		user = new Usuario("juan");
		auto = new AutoEnAlquiler(5000.0,5,"ford",new Flexible());
		reserva = new Reserva(5, LocalDate.now().plusDays(7),auto,user);
	}
	
	@Test
	public void testReservas() {
		assertEquals(this.reserva.montoAPagar(),25000.0);
	}
	
	@Test
	public void testDevoluciones() {
		assertEquals(auto.getPolitica().getClass(), Flexible.class);
		assertEquals(reserva.montoAReembolsar(),25000.0);
		auto.setPolitica(new Moderada());
		assertEquals(auto.getPolitica().getClass(), Moderada.class);
		assertEquals(reserva.montoAReembolsar(),25000.0);
		reserva.setFecha(LocalDate.now().plusDays(2));
		assertEquals(reserva.montoAReembolsar(),12500.0);
		auto.setPolitica(new Estricta());
		assertEquals(auto.getPolitica().getClass(), Estricta.class);
		assertEquals(reserva.montoAReembolsar(),0.0);
	}
	
	
	
}
