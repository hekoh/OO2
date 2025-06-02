package Test;

import Clases.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.time.LocalDate;
import java.util.List;

public class testInscripciones {
	private Excursion excursion;
	private Usuario usuario1;
	
	
	
	@BeforeEach
	public void setup() {
		this.excursion = new Excursion("Dos días en kayak bajando el Paraná",
				LocalDate.of(2025, 6, 5),LocalDate.of(2025, 6, 10), "Paraná",
				100.0,2,3);		//minimo 2, maximo 3
		this.usuario1 = new Usuario("Luca", "Gerace", "GeraceLuca@gmail.com");
		excursion.inscribir(usuario1);
	}
	
	@Test
	public void excursionProvisoria() {
		assertEquals(excursion.getEstado().getClass(),Provisoria.class);
		assertEquals(excursion.getEstado().obtenerInformacion(), "\n Inscripciones faltantes para iniciar la excursion: " + 1);
	}
	
	@Test 
	public void excursionDefinitiva() {
		Usuario usuario2 = new Usuario("juan", "fulano", "fulanito@hotmail.com");
		excursion.inscribir(usuario2);
		System.out.println(excursion.obtenerInformacion());
		System.out.println("//////////////////////////////////////////////");
		assertEquals(excursion.getEstado().getClass(),Definitiva.class);
		assertTrue(excursion.obtenerInformacion().contains("fulanito@hotmail.com"));
		assertTrue(excursion.obtenerInformacion().contains("GeraceLuca@gmail.com"));
		assertTrue(excursion.getEstado().obtenerInformacion().contains("Inscripciones para llenar el cupo: "+1));
	}
	
	
	@Test
	public void inscripcionLlena() {
		Usuario usuario2 = new Usuario("juan", "fulano", "fulanito@hotmail.com");
		Usuario usuario3 = new Usuario("Franco","Perez","prueba@yahoo.com");
		Usuario usuario4 = new Usuario("Jose","Mendez", "joseee@hotmail.com");
		excursion.inscribir(usuario2);
		excursion.inscribir(usuario3);
		assertEquals(excursion.getEstado().getClass(),Llena.class);
		assertEquals(excursion.getEstado().obtenerInformacion(),"");
		excursion.inscribir(usuario4);
		assertTrue(excursion.getEspera().contains(usuario4));
		System.out.println("//////////////////////////////////////////////");
		System.out.println(excursion.obtenerInformacion());
		System.out.println("//////////////////////////////////////////////");
	}
}
